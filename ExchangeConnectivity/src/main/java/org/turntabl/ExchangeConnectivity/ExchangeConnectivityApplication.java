package org.turntabl.ExchangeConnectivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.turntabl.ExchangeConnectivity.model.ClientOrder;
import org.turntabl.ExchangeConnectivity.model.Order;
import org.turntabl.ExchangeConnectivity.utility.MapTo;
import reactor.core.publisher.Mono;
import redis.clients.jedis.Jedis;


@SpringBootApplication
public class ExchangeConnectivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeConnectivityApplication.class, args);

//		List<ClientOrder> clientOrders = new ArrayList<>();

//		Jedis publisher = new Jedis();

        int numb = 1;

        do {

            Jedis orderQueue = new Jedis();

            String clientOrderString = orderQueue.rpop("OrderBook Request");

            System.out.println("Number " + numb);

            if (clientOrderString != null) {

                System.out.println(clientOrderString);

                ClientOrder clientOrder = MapTo.convertToObject(clientOrderString, ClientOrder.class);

                Order order = new Order(clientOrder.getTicker(), String.valueOf(clientOrder.getQuantity()), String.valueOf(clientOrder.getPrice()), clientOrder.getSide());

                System.out.println(MapTo.convertToString(order));

                String url = clientOrder.getUrl();
                System.out.println(url);

                String orderid = placeOrder(url, order);

                System.out.println(orderid);

                orderid = orderid.replace("\"", "");

                clientOrder.setOrderKey(orderid);

                System.out.println(MapTo.convertToString(clientOrder));

                orderQueue.lpush("Placed Orders", MapTo.convertToString(clientOrder));//);

            }else {
                System.out.println("Nothing in Trading Engine queue.");
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String updateOrderString = orderQueue.rpop("Placed Orders");

            System.out.println(updateOrderString);

            if (updateOrderString != null){
                //update
                ClientOrder updateClientOrder = MapTo.convertToObject(updateOrderString, ClientOrder.class);

                Order updOrder = new Order(updateClientOrder.getTicker(),String.valueOf(updateClientOrder.getQuantity()), String.valueOf(updateClientOrder.getPrice()), updateClientOrder.getSide());

                System.out.println(updateOrder(updateClientOrder.getUrl(), updateClientOrder.getOrderKey(), updOrder));

                //orderQueue.lpush("Placed Orders", MapTo.convertToString(updateclientOrder));
            }


//
//            //check
//            System.out.println(checkOrder(uCliOrder.getUrl(), uCliOrder.getOrderKey()));
//
//            //del
//            System.out.println(cancelOrder(uCliOrder.getUrl(), uCliOrder.getOrderKey()));


//			publisher.publish("Exchange Connectivity", "The order has been placed with an id of "+orderid);

            numb++;
        } while (true);


	}

	//Creating a webClient
	private static WebClient createClient(String url){

		return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
	}

	//Configured & Tested
	public static String placeOrder(String url, Order order){

		WebClient client = createClient(url);

		return client.post()
                .uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order")
                .body(Mono.just(order), Order.class)
                .retrieve().bodyToMono(String.class).block();
	}

	//Configured, Not Tested
	public static String updateOrder(String url, String id, Order order){

		WebClient client = createClient(url);

		order.setProduct("ORCL");

        System.out.println("\nUpdating order with id : " + id);

        Boolean state = client.put()
				.uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order/" + id)
				.body(Mono.just(order), Order.class)
				.retrieve().bodyToMono(Boolean.class).block();

		if(!state){return "Could not update";}
		else return "Updated";
	}

	//Configured & Tested
	public static String cancelOrder(String url, String orderId){

		WebClient client = createClient(url);

        System.out.println("\nCancelling order with id : " + orderId);

        Boolean state = client.delete()
				.uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order/" + orderId)
                .retrieve().bodyToMono(Boolean.class)
                .block();

        if (!state) {
            return "Failed : No order by that id OR Could not reach exchange";
        } else { return "Cancelled";}
//		return "";
 	}

	//Configured, Not Tested
	public static String checkOrder(String url, String id){

        WebClient client = createClient(url);

        System.out.println("\nChecking order with id : " + id);

		return client.get()
                .uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(String.class).block();
	}

}
