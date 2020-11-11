package java.com.example.demo.model;

public class Order {

    private long id;
    private OrderStatus status = OrderStatus.OPEN;


    public Order() {
    }

    public Order(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = OrderStatus.valueOf(status);
    }

    public static Order valueOf(String value) {
        return new Order(Long.valueOf(value));


    }

}