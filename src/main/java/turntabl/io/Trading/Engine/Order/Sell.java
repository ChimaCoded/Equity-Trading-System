package turntabl.io.Trading.Engine.Order;

public class Sell {
    private double orderBookPrice;

    private double sellPrice;


    public Sell() {
    }

    public Sell(double orderBookPrice) {
        this.orderBookPrice = orderBookPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice() {
        this.sellPrice = this.orderBookPrice;
    }
}
