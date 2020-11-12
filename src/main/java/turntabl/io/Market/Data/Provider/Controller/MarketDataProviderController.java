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
    /*public WebClient web_client = WebClient.builder()
            .baseUrl("https://exchange.matraining.com")
            .defaultHeader("Content-Type", "application/json")
            .build();*/

    /*@PostMapping("/data")
    public Flux<MarketData> postMarketData(){

        ArrayList<MarketData> marketData = new ArrayList<>();

        MarketData MSTFmarketData = new MarketData(0, 0, 5000, "MSFT",
                40, 0, 10000);

        MarketData NTFLXmarketData = new MarketData(0, 0, 5000, "NTLX",
                20, 0, 10000);

        MarketData GOOGLmarketData = new MarketData(	0, 0, 5000, "GOOGL",
                150, 0, 10000);

        MarketData AAPLmarketData = new MarketData(	0, 0, 5000, "AAPL",
                15, 0, 10000);

        MarketData TSLAmarketData = new MarketData(	0, 0.11, 5000, "TSLA",
                3, 0, 10000);

        MarketData IBMmarketData = new MarketData(	0, 1.3, 5000, "IBM",
                10, 0, 10000);

        MarketData ORCLmarketData = new MarketData(	0, 0, 5000, "ORCL",
                5, 0, 10000);

        MarketData AMZNmarketData = new MarketData(	0, 0, 5000, "AMZN",
                200, 0, 10000);

        /*marketData.add(MSTFmarketData);
        marketData.add(NTFLXmarketData);
        marketData.add(GOOGLmarketData);
        marketData.add(AAPLmarketData);
        marketData.add(TSLAmarketData);
        marketData.add(IBMmarketData);
        marketData.add(ORCLmarketData);
        marketData.add(AMZNmarketData);*/

        /*return web_client.post().uri("/data")
                .body(Mono.just(TSLAmarketData), MarketData.class).retrieve()
                .bodyToFlux(MarketData.class);
    }

    @GetMapping("/data")
    public Flux<MarketData> marketData(){

        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }

        Flux<MarketData> returned_list = web_client.get()
                .uri("/data")
                .retrieve()
                .bodyToFlux(MarketData.class);

        return returned_list;
    }

    /*@GetMapping("/data")
    public String getData(){
        MarketData market_data = new MarketData();
        return market_data.toString();
    }*/

    /*@GetMapping("/data")
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
    }*/


}
