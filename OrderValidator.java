package java.com.example.demo.Validation;


        import java.com.example.demo.model.Order;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class OrderValidator {
    public static OrderValidation validateOrder(Order order) {
        OrderValidation orderValidity;

        if ((order.getId() % 2) == 0) {
            orderValidity =  new OrderValidation(order, true, null);
        } else {
            List<String> errors = new ArrayList<String>(Arrays.asList("Error 1", "Error 2"));
            orderValidity = new OrderValidation(order, false, errors);
        }

        return orderValidity;
    }

}
