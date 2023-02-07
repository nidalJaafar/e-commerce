package lb.store.bookies.module.order.exception;

public class NotEnoughQuantity extends RuntimeException {
    public NotEnoughQuantity() {
        super("not enough quantity");
    }
}
