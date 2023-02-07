package lb.store.bookies.module.order.mapper;

import lb.store.bookies.module.cart.entity.Cart;
import lb.store.bookies.module.order.dto.OrderDto;
import lb.store.bookies.module.order.entity.Order;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    List<OrderDto> orderListToOrderDtoList(List<Order> orderList);

    Order cartToOrder(Cart cart);
    List<Order> cartListToOrderList(List<Cart> cartList);
}
