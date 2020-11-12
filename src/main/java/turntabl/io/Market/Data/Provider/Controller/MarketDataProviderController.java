package turntabl.io.Market.Data.Provider.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import turntabl.io.Market.Data.Provider.Model.MarketDataProvider;


@RestController
public class MarketDataProviderController {

    private WebClient web_client = WebClient.builder()
            .baseUrl("https://exchange.matraining.com")
            .defaultHeader("Content-Type", "application/json")
            .build();

    @GetMapping("/data")
    public Mono<MarketDataProvider[]> getData(){
        Mono<MarketDataProvider[]> data = web_client.get()
                                    .uri("/md")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .retrieve()
                                    .bodyToMono(MarketDataProvider[].class);
        return data;
    }

}
