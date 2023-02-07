package lb.store.bookies.common.mapper;

import lb.store.bookies.module.cart.dto.CartDto;
import lb.store.bookies.common.entity.Cart;
import lb.store.bookies.common.util.AuthenticatedUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Cart mapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class CartMapper {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * Cart to cart dto cart dto.
     *
     * @param cart the cart
     * @return the cart dto
     */
    public CartDto cartToCartDto(Cart cart) {
        return new CartDto()
                .setProduct(productMapper.productToProductDto(cart.getProduct()))
                .setUser(userMapper.userToUserDto(AuthenticatedUser.getAuthenticatedUser()))
                .setQuantity(cart.getQuantity());
    }

    /**
     * Cart list to cart dto list list.
     *
     * @param cartList the cart list
     * @return the list
     */
    public abstract List<CartDto> cartListToCartDtoList(List<Cart> cartList);
}
