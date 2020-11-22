package turntabl.io.Market.Data.Provider.Queue;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import redis.clients.jedis.Jedis;
import turntabl.io.Market.Data.Provider.MarketData.MarketData;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MarketDataQueue {

    private List<MarketData> marketDataRepository = new ArrayList<>();


    private WebClient getBuild(String url) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    WebClient web_client = getBuild("https://exchange.matraining.com");
    WebClient web_client_2 = getBuild("https://exchange2.matraining.com");

    /*@GetMapping("/data")
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

            if (!repository.isEmpty() && repository.size() >= 16){
                repository.clear();
            }
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

            if (!repository.isEmpty() && repository.size() >= 16){
                repository.clear();
            }
            repository.add(marketData);

        });

        return repository;
    }*/

    public void thread() {
        //create a thread
        new Thread(new Runnable() {
            //overriding runnable
            Jedis jedis = new Jedis();

            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {

                    }

                    marketDataRepository.clear();

                    Flux<MarketData> marketData1 = web_client.get()
                            .uri("/md")
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(MarketData.class);
                    marketData1.toStream().forEach((MarketData object) -> {
                        object.setUrl("https://exchange.matraining.com");
                        MarketData marketData = new MarketData(object.getLast_traded_price(),
                                object.getSell_limit(), object.getMax_shift_price(),
                                object.getAsk_price(), object.getBuy_limit(), object.getBid_price(),
                                object.getTicker(), object.getUrl());

                        marketDataRepository.add(marketData);
                    });

                    Flux<MarketData> marketData2 = web_client_2.get()
                            .uri("/md")
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(MarketData.class);
                    marketData2.toStream().forEach((MarketData object) -> {
                        object.setUrl("https://exchange2.matraining.com");
                        MarketData marketData = new MarketData(object.getLast_traded_price(),
                                object.getSell_limit(), object.getMax_shift_price(),
                                object.getAsk_price(), object.getBuy_limit(), object.getBid_price(),
                                object.getTicker(), object.getUrl());
                        marketDataRepository.add(marketData);
                    });


                    String markertData = Ultility.convertToString(marketDataRepository);
                    jedis.lpush("Market Data", markertData);
                }
            }
        }).start();
    }
}
