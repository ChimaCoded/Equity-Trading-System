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

    @JsonProperty()
}
