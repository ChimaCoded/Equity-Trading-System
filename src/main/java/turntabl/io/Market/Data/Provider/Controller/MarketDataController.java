package turntabl.io.Market.Data.Provider.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import turntabl.io.Market.Data.Provider.Model.MarketData;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MarketDataController {

    private List<MarketData> repository = new ArrayList<>();

    private WebClient getBuild(String url) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    WebClient web_client = getBuild("https://exchange.matraining.com");
    WebClient web_client_2 = getBuild("https://exchange2.matraining.com");

    @GetMapping("/data")
    public List<MarketData> getMarketData(){
        Flux<MarketData> data = web_client.get()
                                    .uri("/md")
                                    .accept(MediaType.APPLICATION_JSON)
                                    .retrieve()
                                    .bodyToFlux(MarketData.class);
        data.toStream().forEach((MarketData obj) -> {
            MarketData marketData = new MarketData(obj.getLast_traded_price(),
                    obj.getSell_limit(), obj.getMax_shift_price(),
                    obj.getAsk_price(), obj.getBuy_limit(), obj.getBid_price(), obj.getTicker());
            repository.add(marketData);

        });

        Flux<MarketData> data2 = web_client_2.get()
                .uri("/md")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(MarketData.class);

        data2.toStream().forEach((MarketData obj) -> {
            MarketData marketData = new MarketData(obj.getLast_traded_price(),
                    obj.getSell_limit(), obj.getMax_shift_price(),
                    obj.getAsk_price(), obj.getBuy_limit(), obj.getBid_price(),
                    obj.getTicker());
            repository.add(marketData);

        });

        return repository;
    }
}
