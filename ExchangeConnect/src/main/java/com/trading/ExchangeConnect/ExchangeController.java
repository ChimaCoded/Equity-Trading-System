package com.trading.ExchangeConnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
public class ExchangeController {

    //Order clientOrder = new Order("IBM" , "10", "0.99", "BUY");


    @GetMapping("/data")
    public Mono<Ticker[]> getExchange(){
        Mono<Ticker[]> data = null;

                WebClient client = WebClient.builder()
                .baseUrl("https://exchange.matraining.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        data = client.get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Ticker[].class);

        return data;
        // "Exchange Connectivity";
    }

    @PostMapping("/placeorder")
    public String placeOrder(@RequestBody Order clientOrder){
        //String orderid;

        WebClient client = WebClient.builder()
                .baseUrl("https://exchange.matraining.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        String orderid = client.post()
                .uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order")
                .body(Mono.just(clientOrder), Order.class)
                .retrieve().bodyToMono(String.class).block();

        return orderid;
        // "Exchange Connectivity";
    }

    @GetMapping("/getorder/{orderid}")
    public Mono<String> updateOrder(@PathVariable String orderid){
        //String orderid;

        WebClient client = WebClient.builder()
                .baseUrl("https://exchange.matraining.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<String> state = client.get()
                .uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order/"+ orderid)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(String.class);

        return state;
        // "Exchange Connectivity";
    }

//    @PutMapping("/updateorder/{orderid}")
//    public String updateOrder(@RequestBody Order clientOrder, @PathVariable String orderid){
//        //String orderid;
//
//        WebClient client = WebClient.builder()
//                .baseUrl("https://exchange.matraining.com")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        String state = client.put()
//                .uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order/"+ orderid)
//                .body(Mono.just(clientOrder), Order.class)
//                .retrieve().bodyToMono(String.class).block();
//
//        return state;
//        // "Exchange Connectivity";
//    }

    @DeleteMapping("/cancelorder/{orderid}")
    public Boolean cancelOrder(@PathVariable String orderid){
        Boolean state;

        WebClient client = WebClient.builder()
                .baseUrl("https://exchange.matraining.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        state = client.delete()
                .uri("/bbae4999-fdd0-4c9b-bc14-f365f701d65f/order/" + orderid)
                .retrieve().bodyToMono(Boolean.class)
                .block();

        return state;
        //return "done";
    }

    @Autowired
    private Publisher messagePublisher;

    @PostMapping("/publish")
    public void publish(@RequestBody String message){
        messagePublisher.publishMessage(message);
    }

    private Subscriber messageSubscriber;

//    @GetMapping("/subscribe")
//    public void subscribe(){
//        messageSubscriber.subscribeToChannel();
//    }

}

