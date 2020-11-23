package org.turntabl.ExchangeConnectivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.turntabl.ExchangeConnectivity.model.ClientOrder;
import org.turntabl.ExchangeConnectivity.model.Order;
import org.turntabl.ExchangeConnectivity.utility.MapTo;
import reactor.core.publisher.Mono;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExchangeConnectivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeConnectivityApplication.class, args);

		List<ClientOrder> clientOrders = new ArrayList<>();

		Jedis publisher = new Jedis();

		while (true){

			Jedis orderQueue = new Jedis();

			clientOrders.clear();

			String clientOrderString = orderQueue.rpop("OrderBook Request");

			if(clientOrderString == null ) continue;

			System.out.println(clientOrderString);

			ClientOrder clientOrder = MapTo.convertToObject(clientOrderString, ClientOrder.class);

//			clientOrders.add(clientOrder);

//			System.out.println(clientOrders.get(0).getUrl());

			Order order = new Order(clientOrder.getTicker(), String.valueOf(clientOrder.getQuantity()), String.valueOf(clientOrder.getPrice()), clientOrder.getSide());

			System.out.println(MapTo.convertToString(order));

			//---------Change Needed --------
			String url = clientOrder.getUrl();

			String orderid = placeOrder(url ,order);

			System.out.println(orderid);

			orderid = orderid.replace("\"","");

			clientOrder.setOrderKey(orderid);

			//------------------------------------

			System.out.println(MapTo.convertToString(clientOrder));

			orderQueue.lpush("Placed Orders");

//			publisher.publish("Exchange Connectivity", "The order has been placed with an id of "+orderid);



//			String updateClientOrderString = orderQueue.rpop("TE-EC_U");
//
//			if(updateClientOrderString != null ){
//
//				System.out.println(updateClientOrderString);
//
//				ClientOrder updateClientOrder = MapTo.convertToObject(updateClientOrderString, ClientOrder.class);
//
//				Order updatedOrder = new Order(updateClientOrder.getTicker(), String.valueOf(updateClientOrder.getQuantity()), "0.12", updateClientOrder.getSide());
//
//				System.out.println(MapTo.convertToString(updatedOrder));
//
//				String url = "";
//
//				if(updateClientOrder.getExchange() == "exchange2"){url = "https://exchange2.matraining.com";}
//				else{ url = "https://exchange.matraining.com";}
//
//
//				String orderid = updateOrder(url , updateClientOrder.getOrderId(), updatedOrder);
//
//				orderid = orderid.replace("\"","");
//
//				System.out.println(orderid);
//
//				System.out.println(MapTo.convertToString(updateClientOrder));
//			}else {
//				System.out.println("Ended");
//				//break;
//			}

		}


	}

	//Creating a webClient
	private static WebClient createClient(String url){

		WebClient client = WebClient.builder()
				.baseUrl(url)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();

		return client;
	}

	//Configured
	public static String placeOrder(String url, Order order){

		WebClient client = createClient(url);

		String orderKey = client.post()
				.uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order")
				.body(Mono.just(order), Order.class)
				.retrieve().bodyToMono(String.class).block();

		return orderKey;
	}

	//UnConfigured
//	public static String updateOrder(String url, String id, Order order){
//
//		WebClient client = createClient(url);
//
//		client.post()
//				.uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order/" + id)
//				.body(Mono.just(order), Order.class)
//				.retrieve().bodyToMono(String.class).block();
//		return "";
//	}

	//Unconfigured
//	public static String cancelOrder(WebClient client, Order order, String orderId){
//		client.post()
//				.uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/"+ orderId)
//				.body(Mono.just(order), Order.class)
//				.retrieve().bodyToMono(String.class).block();
//		return "";
//	}

	//Unconfigured
//	public static String checkOrder(WebClient client, Order order){
//		client.post()
//				.uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/ order")
//				.body(Mono.just(order), Order.class)
//				.retrieve().bodyToMono(String.class).block();
//		return "";
//	}

}
