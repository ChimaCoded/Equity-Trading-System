package turntabl.io.Trading.Engine.Order;

public class Buy {

    private double orderPrice, orderBookPrice;
    private int orderQuantity, orderBookQuantity;


    public Buy(double orderPrice, double orderBookPrice, int orderQuantity, int orderBookQuantity) {
        this.orderPrice = orderPrice;
        this.orderBookPrice = orderBookPrice;
        this.orderQuantity = orderQuantity;
        this.orderBookQuantity = orderBookQuantity;
    }

    public Buy() {
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getOrderBookPrice() {
        return orderBookPrice;
    }

    public void setOrderBookPrice(double orderBookPrice) {
        this.orderBookPrice = orderBookPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getOrderBookQuantity() {
        return orderBookQuantity;
    }

    public void setOrderBookQuantity(int orderBookQuantity) {
        this.orderBookQuantity = orderBookQuantity;
    }
}
