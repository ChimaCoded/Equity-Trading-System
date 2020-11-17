package turntabl.io.Trading.Engine.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import turntabl.io.Trading.Engine.Model.Buy;
import turntabl.io.Trading.Engine.Model.MarketData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MarketDataController {

    private List<MarketData> repository = new ArrayList<>();

    private WebClient getBuild(String url) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    WebClient web_client = getBuild("http://localhost:8080");

    @GetMapping("/")
    public List<MarketData> getMarketData(){
        Flux<MarketData> data = web_client.get()
                .uri("/data")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(MarketData.class);
        data.toStream().forEach((MarketData obj) -> {
            MarketData marketData = new MarketData(obj.getLast_traded_price(), obj.getMax_shift_price(),
                    obj.getAsk_price(), obj.getBid_price(), obj.getTicker());

            if (!repository.isEmpty() && repository.size() >= 16){
                repository.clear();
            }
            repository.add(marketData);

        });
        return repository;
    }

    @GetMapping("/{ticker}")
    public List<Optional<MarketData>> controllerFilterByTicker(@PathVariable("ticker") String ticker){
        Buy buy = new Buy();
        return buy.filterByTicker(ticker, repository);
    }





}
