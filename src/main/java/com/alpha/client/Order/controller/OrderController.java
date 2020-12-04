//package com.alpha.client.Order.controller;
//
//import com.alpha.client.Order.model.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//
//@RestController
//public class OrderController {
//
////    @Autowired
////    OrderRepository Ordrepository;
////
////    @PostMapping("/createOrder")
////    public String create(@RequestBody Order order){
////
////        WebClient client = new WebClient.builder();
////        // save a single Order
////        Ordrepository.save(order);
////
////        return "Order is created";
////    }
////
//
//
//
//    @PostMapping("/createOrder")
//    public String createorder(@RequestBody Order order) {
//        //String orderid;
//
//        //order = new Order(23, "C02", "P02", "IBM", "Buy", 2);
//
//        return order.getTicker();
//    }
//
//
//
//    @PostMapping("/createOrder")
//    public String create(@RequestBody Order order) {
//        //String orderid;
//
//        order = new Order(23, "C02", "P02", "IBM", "Buy", 2  );
//
//        WebClient client = WebClient.builder()
//                .baseUrl("localhost:8082")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        String orderId = client.post()
//                .uri("/singleOrder")
//                .body(Mono.just(order), Order.class)
//                .retrieve().bodyToMono(String.class).block();
//
//        return orderId;
//    }
//
//
//
//
//
//
//
//
//
//
//
////    @GetMapping("/findallOrder")
////    public List<Order> findAll(){
////
////        List<Order> orders = (List<Order>) Ordrepository.findAll();
////        List<Order> orderUI = new ArrayList<>();
////
////        for (Order order : orders) {
////            orderUI.add(new Order(order.getTicker(), order.getSide(), order.getQuantity(), order.getPrice()));
////        }
////
////        return orderUI;
////    }
//
//
//}
