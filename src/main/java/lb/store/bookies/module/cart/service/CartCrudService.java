package lb.store.bookies.module.cart.service;

import lb.store.bookies.module.cart.request.CartRequest;
import lb.store.bookies.module.cart.response.CartResponse;

/**
 * Cart crud service.
 */
public interface CartCrudService {
    /**
     * Post cart response.
     *
     * @param request the request
     * @return the cart response
     */
    CartResponse post(CartRequest request);

    /**
     * Get cart response.
     *
     * @return the cart response
     */
    CartResponse get();
}
