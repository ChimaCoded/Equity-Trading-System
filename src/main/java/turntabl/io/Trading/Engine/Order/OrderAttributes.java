package turntabl.io.Trading.Engine.Order;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderAttributes {

    private String orderId;

    private String clientId;

    private String portfolioId;

    private String ticker;

    private double price;

    private int quantity;

    private String side;

    private String timeStamp;

    public OrderAttributes() {
    }


    public OrderAttributes(String orderId, String clientId, String portfolioId,
                           String ticker, double price, int quantity,
                           String side, String timeStamp) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.ticker = ticker;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.timeStamp = timeStamp;
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
}
