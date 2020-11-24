package turntabl.io.Trading.Engine.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private String orderId;

    private String clientId;

    private String portfolioId;

    private String ticker;

    private double price;

    private int quantity;

    private String side;

    private String timeStamp;

    private double bidPrice;

    private String url;

    private double sellPrice;

    public Order(String orderId, String clientId, String portfolioId, String ticker,
                 double price, int quantity, String side, String timeStamp) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.ticker = ticker;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.timeStamp = timeStamp;
    }

    public Order() {
    }

    //buy
    public Order(String orderId, String clientId, String portfolioId, String ticker,
                 double price, int quantity, String side, String timeStamp, double bidPrice,
                 String url) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.ticker = ticker;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.timeStamp = timeStamp;
        this.bidPrice = bidPrice;
        this.url = url;
    }

    //sell
    public Order(String orderId, String clientId, String portfolioId, String ticker,
                 int quantity, String side, String timeStamp, String url,
                 double sellPrice) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.ticker = ticker;
        this.quantity = quantity;
        this.side = side;
        this.timeStamp = timeStamp;
        this.url = url;
        this.sellPrice = sellPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", portfolioId='" + portfolioId + '\'' +
                ", ticker='" + ticker + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", side='" + side + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", bidPrice=" + bidPrice +
                ", url='" + url + '\'' +
                ", sellPrice=" + sellPrice +
                '}';
    }
}
