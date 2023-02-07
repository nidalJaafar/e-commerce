package lb.store.bookies.module.order.service;

import lb.store.bookies.module.order.request.OrderDeleteRequest;
import lb.store.bookies.module.order.request.OrderRequest;
import lb.store.bookies.module.order.response.OrderResponse;

import java.util.UUID;

/**
 * Order crud service.
 */
public interface OrderCrudService {

    /**
     * Get order response.
     *
     * @return the order response
     */
    OrderResponse get();

    /**
     * Place order response.
     *
     * @return the order response
     */
    OrderResponse placeOrder();

    /**
     * Delete.
     *
     * @param request the request
     */
    void delete(OrderDeleteRequest request);

    /**
     * Put order response.
     *
     * @param request the request
     * @return the order response
     */
    OrderResponse put(OrderRequest request);

    /**
     * Gets all.
     *
     * @return the all
     */
    OrderResponse getAll();

    /**
     * Gets all by user.
     *
     * @param userId the user id
     * @return the all by user
     */
    OrderResponse getAllByUser(UUID userId);
}
