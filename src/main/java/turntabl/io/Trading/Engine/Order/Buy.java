package turntabl.io.Trading.Engine.Order;

public class Buy {

    private double orderBalance;

    private double orderBookPrice;

    private double bidPrice;

    private int orderQuantity, orderBookQuantity;

    private double accountBalance;


    public Buy(double orderBalance, double orderBookPrice, int orderQuantity, int orderBookQuantity) {
        this.orderBalance = orderBalance;
        this.orderBookPrice = orderBookPrice;
        this.orderQuantity = orderQuantity;
        this.orderBookQuantity = orderBookQuantity;
    }

    public Buy() {
    }

    public double getOrderBalance() {
        return orderBalance;
    }

    public void setOrderBalance(double orderBalance) {
        this.orderBalance = orderBalance;
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

    public void setOrderQuantity() {
        this.orderQuantity = this.orderBookQuantity;
    }

    public int getOrderBookQuantity() {
        return orderBookQuantity;
    }

    public void setOrderBookQuantity(int orderBookQuantity) {

        this.orderBookQuantity = orderBookQuantity;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice() {
        this.bidPrice = this.orderBookPrice;
    }

    public double balance(){
        this.accountBalance = this.orderBookPrice * this.orderBookQuantity;
        return this.accountBalance;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "orderPrice=" + orderBalance +
                ", orderBookPrice=" + orderBookPrice +
                ", orderQuantity=" + orderQuantity +
                ", orderBookQuantity=" + orderBookQuantity +
                '}';
    }
}
