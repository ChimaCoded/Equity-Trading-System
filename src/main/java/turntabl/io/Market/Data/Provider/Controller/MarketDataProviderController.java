package turntabl.io.Market.Data.Provider.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import turntabl.io.Market.Data.Provider.Model.MarketDataProvider_Exchange;
import turntabl.io.Market.Data.Provider.Model.MarketDataProvider_Exchange2;


@RestController
public class MarketDataProviderController {

    private WebClient getBuild(String url) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    WebClient web_client = getBuild("https://exchange.matraining.com");
    WebClient web_client_2 = getBuild("https://exchange2.matraining.com");

    @GetMapping("/data")
    public Mono<MarketDataProvider_Exchange[]> getData(){
        Mono<MarketDataProvider_Exchange[]> data = web_client.get()
                                    .uri("/md")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .retrieve()
                                    .bodyToMono(MarketDataProvider_Exchange[].class);
        return data;
    }
    @GetMapping("/data2")
    public Mono<MarketDataProvider_Exchange2[]> getData2(){
        Mono<MarketDataProvider_Exchange2[]> data = web_client_2.get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(MarketDataProvider_Exchange2[].class);
        return data;
    }


}
