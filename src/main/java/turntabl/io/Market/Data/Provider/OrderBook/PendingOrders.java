package turntabl.io.Market.Data.Provider.OrderBook;


//structure for all pending orders from Mallon Exchange orderbook

import com.fasterxml.jackson.annotation.JsonProperty;

public class PendingOrders {

    @JsonProperty("product")
    private String product;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("price")
    private double price;

    @JsonProperty("side")
    private String side;

    @JsonProperty("cumulativeQuantity")
    private int cumulativeQuantity;

    private String url;



    public PendingOrders() {
    }

    public PendingOrders(String product, int quantity, double price, String side,
                         int cumulativeQuantity, String url) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.cumulativeQuantity = cumulativeQuantity;
        this.url = url;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getCumulativeQuantity() {
        return cumulativeQuantity;
    }

    public void setCumulativeQuantity(int cumulativeQuantity) {
        this.cumulativeQuantity = cumulativeQuantity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PendingOrders{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", side='" + side + '\'' +
                ", cumulativeQuantity=" + cumulativeQuantity +
                ", url='" + url + '\'' +
                '}';
    }
}
