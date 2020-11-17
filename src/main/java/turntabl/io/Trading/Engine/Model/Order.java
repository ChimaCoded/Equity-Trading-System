package turntabl.io.Trading.Engine.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("clientId")
    private String clientId;

    @JsonProperty("portfolioId")
    private String portfolioId;

    @JsonProperty("side")
    private String side;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("statusId")
    private String statusId;

    @JsonProperty("ticker")
    private String ticker;

    @JsonProperty("timeStamp")
    private String timeStamp;

    public Order() {
    }


    public Order(String orderId, String clientId, String portfolioId, String side,
                 int quantity, String statusId, String ticker, String timeStamp) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.side = side;
        this.quantity = quantity;
        this.statusId = statusId;
        this.ticker = ticker;
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

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
