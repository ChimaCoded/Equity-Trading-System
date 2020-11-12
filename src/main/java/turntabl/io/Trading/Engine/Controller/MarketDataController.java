package turntabl.io.Trading.Engine.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import turntabl.io.Trading.Engine.Model.MarketData;

@RestController
public class MarketDataController {

    public WebClient web_client = WebClient.builder()
            .baseUrl("https://exchange.matraining.com")
            .defaultHeader("Content-Type", "application/json")
            .build();


    /*@GetMapping("/data")
    public Flux<MarketData> marketData(){
        return web_client.get()
                .uri("/md")
                .retrieve()
                .bodyToFlux(MarketData.class);
    }*/

    /*@GetMapping("/data")
    public String getData(){
        MarketData market_data = new MarketData();
        return market_data.toString();
    }*/

    @GetMapping("/data")
    public Flux<MarketData> market_data() {
        Flux<MarketData> return_list = web_client.get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(MarketData.class);
        return_list.toStream().forEach((MarketData object) -> {
            System.out.println(object);
        });

        return return_list;
    }
}
