package turntabl.io.Trading.Engine.Model;

public class MarketData {

    private int last_traded_price, sell_limit, max_shift_price, ask_price, buy_limit;
    private double bid_price;
    private String ticker;

    public MarketData() {

    }

    public int getLast_traded_price() {
        return last_traded_price;
    }

    public void setLast_traded_price(int last_traded_price) {
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

    public int getMax_shift_price() {
        return max_shift_price;
    }

    public void setMax_shift_price(int max_shift_price) {
        this.max_shift_price = max_shift_price;
    }

    public int getAsk_price() {
        return ask_price;
    }

    public void setAsk_price(int ask_price) {
        this.ask_price = ask_price;
    }

    public int getBuy_limit() {
        return buy_limit;
    }

    public void setBuy_limit(int buy_limit) {
        this.buy_limit = buy_limit;
    }
}
