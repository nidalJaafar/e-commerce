package lb.store.bookies.module.order.exception;

/**
 * Not enough quantity.
 */
public class NotEnoughQuantity extends RuntimeException {
    /**
     * Instantiates a new Not enough quantity.
     */
    public NotEnoughQuantity() {
        super("not enough quantity");
    }
}
