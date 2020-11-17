package turntabl.io.Trading.Engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import turntabl.io.Trading.Engine.Model.MarketData;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TradingEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingEngineApplication.class, args);
	}

}
