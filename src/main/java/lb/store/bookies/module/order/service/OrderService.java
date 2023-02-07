package lb.store.bookies.module.order.service;

import lb.store.bookies.module.order.request.OrderDeleteRequest;
import lb.store.bookies.module.order.request.OrderRequest;
import lb.store.bookies.module.order.response.OrderResponse;

import java.util.UUID;

public interface OrderService {

    OrderResponse get();

    OrderResponse placeOrder();

    void delete(OrderDeleteRequest request);

    OrderResponse put(OrderRequest request);

    OrderResponse getAll();

    OrderResponse getAllByUser(UUID userId);
}
