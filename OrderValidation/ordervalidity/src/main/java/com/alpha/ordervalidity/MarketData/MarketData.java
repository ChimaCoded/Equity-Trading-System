package com.alpha.ordervalidity.MarketData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketData {

    private double last_traded_price;

    private double max_shift_price;

    private double ask_price;

    private double bid_price;

    private String ticker;

    private String url;

    public MarketData() {

    }

    public MarketData(double last_traded_price,
                      double max_shift_price, double ask_price,
                      double bid_price, String ticker) {

        this.last_traded_price = last_traded_price;
        this.bid_price = bid_price;
        this.ticker = ticker;
        this.max_shift_price = max_shift_price;
        this.ask_price = ask_price;
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

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "last_traded_price=" + last_traded_price +
                ", max_shift_price=" + max_shift_price +
                ", ask_price=" + ask_price +
                ", bid_price=" + bid_price +
                ", ticker='" + ticker + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
