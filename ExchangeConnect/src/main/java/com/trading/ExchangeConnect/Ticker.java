package com.trading.ExchangeConnect;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticker {

    @JsonProperty("LAST_TRADED_PRICE")
    private double LAST_TRADED_PRICE;

    @JsonProperty("BID_PRICE")
    private double BID_PRICE;

    @JsonProperty("SELL_LIMIT")
    private int SELL_LIMIT;

    @JsonProperty("TICKER")
    private String TICKER;

    @JsonProperty("MAX_PRICE_SHIFT")
    private int MAX_PRICE_SHIFT;

    @JsonProperty("ASK_PRICE")
    private double ASK_PRICE;

    @JsonProperty("BUY_LIMIT")
    private int BUY_LIMIT;

    public Ticker(){

    }

    public Ticker(double LAST_TRADED_PRICE, double BID_PRICE, int SELL_LIMIT, String TICKER, int MAX_PRICE_SHIFT, double ASK_PRICE, int BUY_LIMIT){
        this.LAST_TRADED_PRICE = LAST_TRADED_PRICE;
        this.BID_PRICE = BID_PRICE;
        this.ASK_PRICE = ASK_PRICE;
        this.SELL_LIMIT = SELL_LIMIT;
        this.TICKER = TICKER;
        this.MAX_PRICE_SHIFT = MAX_PRICE_SHIFT;
        this.BUY_LIMIT = BUY_LIMIT;
    }

    public void setLAST_TRADED_PRICE(double LAST_TRADED_PRICE) {
        this.LAST_TRADED_PRICE = LAST_TRADED_PRICE;
    }

    public void setBID_PRICE(double BID_PRICE) {
        this.BID_PRICE = BID_PRICE;
    }

    public void setSELL_LIMIT(int SELL_LIMIT) {
        this.SELL_LIMIT = SELL_LIMIT;
    }

    public void setTICKER(String TICKER) {
        this.TICKER = TICKER;
    }

    public void setMAX_PRICE_SHIFT(int MAX_PRICE_SHIFT) {
        this.MAX_PRICE_SHIFT = MAX_PRICE_SHIFT;
    }

    public void setASK_PRICE(double ASK_PRICE) {
        this.ASK_PRICE = ASK_PRICE;
    }

    public void setBUY_LIMIT(int BUY_LIMIT) {
        this.BUY_LIMIT = BUY_LIMIT;
    }
    
    @Override
    public String toString(){
        return "MarketData{\n" +
                "Ticker : " + TICKER +"\n" +
                "Ticker : " + SELL_LIMIT +"\n" +
                "Ticker : " + ASK_PRICE +"\n" +
                "Ticker : " + BID_PRICE +"\n" +
                "Ticker : " + LAST_TRADED_PRICE +"\n" +
                "Ticker : " + MAX_PRICE_SHIFT +"\n" +
                "Ticker : " + BUY_LIMIT +"\n";
    }

}
