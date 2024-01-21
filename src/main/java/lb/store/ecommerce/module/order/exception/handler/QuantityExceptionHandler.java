package lb.store.ecommerce.module.order.exception.handler;

import lb.store.ecommerce.container.exception.response.ExceptionResponse;
import lb.store.ecommerce.module.order.exception.NotEnoughQuantity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuantityExceptionHandler {
    @ExceptionHandler(value = NotEnoughQuantity.class)
    public ExceptionResponse notEnoughQuantity() {
        return new ExceptionResponse().setMessage("not enough quantity");
    }
}
