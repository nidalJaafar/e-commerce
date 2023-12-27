package lb.store.ecommerce.module.order.mapper;

import lb.store.ecommerce.common.entity.Cart;
import lb.store.ecommerce.common.entity.Order;
import lb.store.ecommerce.module.order.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Order mapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    /**
     * Order to order dto.
     *
     * @param order the order
     * @return the order dto
     */
    OrderDto orderToOrderDto(Order order);

    /**
     * Order list to order dto list.
     *
     * @param orderList the order list
     * @return the list
     */
    List<OrderDto> orderListToOrderDtoList(List<Order> orderList);

    /**
     * Cart to order.
     *
     * @param cart the cart
     * @return the order
     */
    Order cartToOrder(Cart cart);

    /**
     * Cart list to order list.
     *
     * @param cartList the cart list
     * @return the list
     */
    List<Order> cartListToOrderList(List<Cart> cartList);
}
