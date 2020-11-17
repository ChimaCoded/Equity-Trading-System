package turntabl.io.Trading.Engine.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Buy {

    private double lastTradedPrice, maxShiftPrice, askPrice, bidPrice;
    private String ticker;

    private List<Optional<MarketData>> filtered = new ArrayList<>();

    //private double best_max_shift_price;

    public List<Optional<MarketData>> filterByTicker (String ticker, List<MarketData> marketData) {
        //filter by ticker and collect data to list
        Optional<MarketData> data = marketData.stream().filter(
                tick -> tick.getTicker().equals(ticker)).collect(Collectors.toList())
                .stream()
                .max(Comparator.comparing(MarketData::getMax_shift_price));
        filtered.add(data);
        return filtered;
    }

    public void data(){
        filtered.get(0).map();
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
