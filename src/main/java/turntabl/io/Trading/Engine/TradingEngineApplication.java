package turntabl.io.Trading.Engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import turntabl.io.Trading.Engine.Queue.FinalOrderQueue;

@SpringBootApplication
public class TradingEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingEngineApplication.class, args);

//		MarketDataQueueMonitor marketDataQueueMonitor = new MarketDataQueueMonitor();
//		marketDataQueueMonitor.getFromQueue();

		FinalOrderQueue finalOrderQueue = new FinalOrderQueue();
		finalOrderQueue.thread();

		}

}


