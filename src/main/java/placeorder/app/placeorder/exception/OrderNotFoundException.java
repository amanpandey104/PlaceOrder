package placeorder.app.placeorder.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id) {
        super("Order with ID " + id + " not found.");
    }
}
