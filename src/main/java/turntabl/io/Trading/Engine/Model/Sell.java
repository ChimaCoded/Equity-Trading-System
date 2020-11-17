package turntabl.io.Trading.Engine.Model;

public class Sell {

    MarketData market_data = new MarketData();

    private double best_last_traded_price;

    /*public double comparing_last_traded_price(){
        if (market_data.getLast_traded_price() > market_data_2.getLast_traded_price()){
            best_last_traded_price = market_data.getLast_traded_price();
        }
        else{
            best_last_traded_price = market_data_2.getLast_traded_price();
        }

        return best_last_traded_price;
    }*/
}
