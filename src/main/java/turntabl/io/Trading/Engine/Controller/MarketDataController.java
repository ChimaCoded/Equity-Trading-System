package turntabl.io.Trading.Engine.Controller;

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


    @GetMapping("/data")
    public Flux<MarketData> marketData(){
        return web_client.get()
                .uri("/md")
                .retrieve()
                .bodyToFlux(MarketData.class);
    }
}
