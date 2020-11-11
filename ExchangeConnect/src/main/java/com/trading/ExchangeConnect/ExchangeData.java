package com.trading.ExchangeConnect;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ExchangeData {
    WebClient client = WebClient.create("https://exchange.matraining.com");

    Mono<ClientResponse> result = client.get()
            .uri("/md")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();


    public String data(){
        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
