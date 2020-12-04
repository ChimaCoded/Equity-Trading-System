package com.alpha.client.Client.controller;

import com.alpha.client.Client.model.Client;
import com.alpha.client.Client.repo.ClientRepository;
import com.alpha.client.Order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RestController
public class ClientController {
    @Autowired
    ClientRepository repository;

    @PostMapping("/create")
    public String createclient(@RequestBody Client client) {
        // save a single Client
        repository.save(client);

        return "Client is created";

    }

//    @PostMapping("/createOrder")
//    public Order createorder(@RequestBody Order order) {
//        //String orderid;
//        //order = new Order(23, "C02", "P02", "IBM", "Buy", 2);
//
//        WebClient client = WebClient.builder()
//                .baseUrl("localhost:8080")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        String response = client.post()
//                .uri("/abc")
//                .body(Mono.just(order), Order.class)
//                .retrieve().bodyToMono(String.class).block();
//
//
//        return order;
//
//}


    @PostMapping("/newOrder")
    public String neworder(@RequestBody Order order){

        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        String response = client.post()
                .uri("/neworder")
                .body(Mono.just(order), Order.class)
                .retrieve().bodyToMono(String.class).block();


        return response;


    }

















//    @GetMapping("/findall")
//    public List<ClientUI> findAll(){
//
//        List<Client> clients = repository.findAll();
//        List<ClientUI> clientUI = new ArrayList<>();
//
//        for (Client client : clients) {
//            clientUI.add(new ClientUI(client.getFirstName(),client.getLastName(), client.getPassword(), client.getEmailAddress(), client.getBankBalance()));
//        }
//
//        return clientUI;
//    }
//
//    @RequestMapping("/search/{id}")
//    public String search(@PathVariable long id){
//        String client = "";
//        client = repository.findById(id).toString();
//        return client;
//    }
//
//    @RequestMapping("/searchbyfirstname/{firstname}")
//    public List<ClientUI> fetchDataByLastName(@PathVariable String firstname) {
//
//        List<Client> clients = repository.findByFirstName(firstname);
//        List<ClientUI> clientUI = new ArrayList<>();
//
//        for (Client client : clients) {
//            clientUI.add(new ClientUI(client.getFirstName(), client.getLastName(), client.getPassword(), client.getEmailAddress(), client.getBankBalance()));
//            //clientUI.add(new OrderUI(Order.)
//
//        }
//
//        return clientUI;
//
//    }
//
//
//
//
//
}