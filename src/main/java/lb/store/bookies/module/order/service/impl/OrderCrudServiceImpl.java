package lb.store.bookies.module.order.service.impl;

import lb.store.bookies.common.repository.CartRepository;
import lb.store.bookies.common.repository.OrderRepository;
import lb.store.bookies.common.repository.ProductRepository;
import lb.store.bookies.common.entity.Cart;
import lb.store.bookies.common.entity.Order;
import lb.store.bookies.module.order.exception.NotEnoughQuantity;
import lb.store.bookies.module.order.mapper.OrderMapper;
import lb.store.bookies.module.order.request.OrderDeleteRequest;
import lb.store.bookies.module.order.request.OrderRequest;
import lb.store.bookies.module.order.response.OrderResponse;
import lb.store.bookies.module.order.service.OrderCrudService;
import lb.store.bookies.common.entity.Product;
import lb.store.bookies.common.util.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Order crud service.
 */
@Service
@RequiredArgsConstructor
public class OrderCrudServiceImpl implements OrderCrudService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;

    @Override
    public OrderResponse get() {
        List<Order> orders = orderRepository.findAllByUserId(AuthenticatedUser.getAuthenticatedUser().getId());
        return new OrderResponse().setOrderDtoList(orderMapper.orderListToOrderDtoList(orders));
    }

    @Override
    public OrderResponse placeOrder() {
        List<Cart> cartList = cartRepository.findAllByUserId(AuthenticatedUser.getAuthenticatedUser().getId());
        cartRepository.deleteAll(cartList);
        List<Order> orders = orderMapper.cartListToOrderList(cartList);
        for (Order order : orders) {
            Product product = order.getProduct();
            long quantity = product.getQuantity() - order.getQuantity();
            if (quantity < 0) throw new NotEnoughQuantity();
            product.setQuantity(quantity);
        }
        return new OrderResponse().setOrderDtoList(orderMapper.orderListToOrderDtoList(orderRepository.saveAll(orders)));
    }

    @Override
    public void delete(OrderDeleteRequest request) {
        List<Product> updatedProducts = new ArrayList<>();
        orderRepository.findAllById(request.getOrderIdList()).forEach(order -> {
            Product product = order.getProduct();
            product.setQuantity(order.getQuantity() + product.getQuantity());
            updatedProducts.add(product);
        });
        productRepository.saveAll(updatedProducts);
        orderRepository.deleteAllByIdInBatch(request.getOrderIdList());
    }

    @Override
    public OrderResponse put(OrderRequest request) {
        Map<UUID, Long> newOrders = request.getOrder(); //order id -----> quantity
        List<Order> savedOrders = orderRepository.findAllById(newOrders.keySet());
        for (Order order : savedOrders) {
            Product product = order.getProduct();
            long quantity = order.getProduct().getQuantity() + order.getQuantity() - newOrders.get(order.getId());
            if (quantity < 0) throw new NotEnoughQuantity();
            product.setQuantity(quantity);
            order.setQuantity(newOrders.get(order.getId()));
        }
        return new OrderResponse().setOrderDtoList(orderMapper.orderListToOrderDtoList(orderRepository.saveAll(savedOrders)));
    }

    @Override
    public OrderResponse getAll() {
        return new OrderResponse().setOrderDtoList(orderMapper.orderListToOrderDtoList(orderRepository.findAll()));
    }

    @Override
    public OrderResponse getAllByUser(UUID userId) {
        return new OrderResponse().setOrderDtoList(orderMapper.orderListToOrderDtoList(orderRepository.findAllByUserId(userId)));
    }
}
