package java.com.example.demo.Validation;
import java.com.example.demo.model.Order;
import java.util.List;

public class OrderValidation {

    boolean valid;
        List<String> errors;
    Order order;

        public OrderValidation(Order order, boolean valid, List<String> errors) {
            this.order = order;
            this.valid = valid;
            this.errors = errors;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public List<String> getErrors() {
            return errors;
        }

        public void setErrors(List<String> errors) {
            this.errors = errors;
        }

    }


