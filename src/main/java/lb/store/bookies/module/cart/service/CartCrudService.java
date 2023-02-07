package lb.store.bookies.module.cart.service;

import lb.store.bookies.module.cart.request.CartRequest;
import lb.store.bookies.module.cart.response.CartResponse;

public interface CartCrudService {
    CartResponse post(CartRequest request);

    CartResponse get();
}
