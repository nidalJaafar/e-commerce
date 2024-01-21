package lb.store.ecommerce.module.cart.service;

import lb.store.ecommerce.module.cart.request.CartRequest;
import lb.store.ecommerce.module.cart.response.CartResponse;

public interface CartCrudService {
    CartResponse post(CartRequest request);

    CartResponse get();
}
