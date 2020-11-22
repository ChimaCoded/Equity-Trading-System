package turntabl.io.Market.Data.Provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import turntabl.io.Market.Data.Provider.MarketData.MarketData;
import turntabl.io.Market.Data.Provider.Queue.MarketDataQueue;
import turntabl.io.Market.Data.Provider.Queue.OrderBookQueue;

@SpringBootApplication
public class MarketDataProviderApplication {

	public static void main(String[] args) {

		SpringApplication.run(MarketDataProviderApplication.class, args);

		OrderBookQueue orderBookQueue = new OrderBookQueue();
		orderBookQueue.thread();

//		MarketDataQueue marketDataQueue = new MarketDataQueue();
//		marketDataQueue.thread();
	}

}
