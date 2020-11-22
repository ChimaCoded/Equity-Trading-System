package turntabl.io.Trading.Engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import turntabl.io.Trading.Engine.Order.Order;
import turntabl.io.Trading.Engine.Queue.MarketDataQueueMonitor;
import turntabl.io.Trading.Engine.Queue.OrderBookQueueMonitor;
import turntabl.io.Trading.Engine.Queue.OrderQueueMonitor;

@SpringBootApplication
public class TradingEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingEngineApplication.class, args);

//		MarketDataQueueMonitor marketDataQueueMonitor = new MarketDataQueueMonitor();
//		marketDataQueueMonitor.getFromQueue();
//
//		OrderBookQueueMonitor orderBookQueueMonitor = new OrderBookQueueMonitor();
//		orderBookQueueMonitor.getFromQueue();

		OrderQueueMonitor orderQueueMonitor = new OrderQueueMonitor();
		orderQueueMonitor.getFromQueue();
	}

}
