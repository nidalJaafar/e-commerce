package lb.store.ecommerce.module.order.service;

import lb.store.ecommerce.module.order.request.OrderDeleteRequest;
import lb.store.ecommerce.module.order.request.OrderRequest;
import lb.store.ecommerce.module.order.response.OrderResponse;

import java.util.UUID;

public interface OrderCrudService {

    OrderResponse get();

    OrderResponse placeOrder();

    void delete(OrderDeleteRequest request);

    OrderResponse put(OrderRequest request);

    OrderResponse getAll();

    OrderResponse getAllByUser(UUID userId);
}
