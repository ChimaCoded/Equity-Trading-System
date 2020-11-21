package turntabl.io.Market.Data.Provider.MarketData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketData {

    @JsonProperty("LAST_TRADED_PRICE")
    private double last_traded_price;

    @JsonProperty("SELL_LIMIT")
    private int sell_limit;

    @JsonProperty("MAX_SHIFT_PRICE")
    private double max_shift_price;

    @JsonProperty("ASK_PRICE")
    private double ask_price;

    @JsonProperty("BUY_LIMIT")
    private int buy_limit;

    @JsonProperty("BID_PRICE")
    private double bid_price;

    @JsonProperty("TICKER")
    private String ticker;

    private String url;

    public MarketData() {

    }

    public MarketData(double last_traded_price, int sell_limit,
                      double max_shift_price, double ask_price,
                      int buy_limit, double bid_price, String ticker, String url) {

        this.last_traded_price = last_traded_price;
        this.bid_price = bid_price;
        this.sell_limit = sell_limit;
        this.ticker = ticker;
        this.max_shift_price = max_shift_price;
        this.ask_price = ask_price;
        this.buy_limit = buy_limit;
        this.url = url;
    }

    public double getLast_traded_price() {

        return last_traded_price;
    }

    public void setLast_traded_price(double last_traded_price) {

        this.last_traded_price = last_traded_price;
    }

    public double getBid_price() {

        return bid_price;
    }

    public void setBid_price(double bid_price) {

        this.bid_price = bid_price;
    }

    public int getSell_limit() {

        return sell_limit;
    }

    public void setSell_limit(int sell_limit) {

        this.sell_limit = sell_limit;
    }

    public String getTicker() {

        return ticker;
    }

    public void setTicker(String ticker) {

        this.ticker = ticker;
    }

    public double getMax_shift_price() {

        return max_shift_price;
    }

    public void setMax_shift_price(double max_shift_price) {

        this.max_shift_price = max_shift_price;
    }

    public double getAsk_price() {

        return ask_price;
    }

    public void setAsk_price(double ask_price) {

        this.ask_price = ask_price;
    }

    public int getBuy_limit() {

        return buy_limit;
    }

    public void setBuy_limit(int buy_limit) {

        this.buy_limit = buy_limit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
