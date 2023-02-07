package lb.store.bookies.module.cart.mapper;

import lb.store.bookies.module.cart.dto.CartDto;
import lb.store.bookies.module.cart.entity.Cart;
import lb.store.bookies.module.product.mapper.ProductMapper;
import lb.store.bookies.security.mapper.UserMapper;
import lb.store.bookies.security.util.AuthenticatedUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class CartMapper {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserMapper userMapper;

    public CartDto cartToCartDto(Cart cart) {
        return new CartDto()
                .setProduct(productMapper.productToProductDto(cart.getProduct()))
                .setUser(userMapper.userToUserDto(AuthenticatedUser.getAuthenticatedUser()))
                .setQuantity(cart.getQuantity());
    }

    public abstract List<CartDto> cartListToCartDtoList(List<Cart> cartList);
}
