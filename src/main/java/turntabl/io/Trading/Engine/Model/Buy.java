package turntabl.io.Trading.Engine.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Buy {

    private List<MarketData> filtered = new ArrayList<>();



    private double best_max_shift_price;

    public Optional<MarketData> filterByTicker (String ticker, List<MarketData> marketData) {
        //filter by ticker and collect data to list
        return marketData.stream().filter(
                tick -> tick.getTicker().equals(ticker)).collect(Collectors.toList())
                .stream()
                .max(Comparator.comparing(MarketData::getMax_shift_price));
    }


    /*public double comparing_max_shift_price(){
        if (market_data.getMax_shift_price() > market_data_2.getMax_shift_price()){
            best_max_shift_price = market_data.getMax_shift_price();
        }
        else{
            best_max_shift_price = market_data_2.getMax_shift_price();
        }
        return best_max_shift_price;
    }*/

}
