package lb.store.ecommerce.module.order.mapper;

import lb.store.ecommerce.common.entity.Cart;
import lb.store.ecommerce.common.entity.Order;
import lb.store.ecommerce.module.order.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    List<OrderDto> orderListToOrderDtoList(List<Order> orderList);

    Order cartToOrder(Cart cart);

    List<Order> cartListToOrderList(List<Cart> cartList);
}
