package lb.store.ecommerce.common.mapper;

import lb.store.ecommerce.common.entity.Cart;
import lb.store.ecommerce.module.cart.dto.CartDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class CartMapper {
    @Autowired
    private ProductMapper productMapper;

    public CartDto cartToCartDto(Cart cart) {
        return new CartDto()
                .setProduct(productMapper.productToProductDto(cart.getProduct()))
                .setQuantity(cart.getQuantity());
    }

    public abstract List<CartDto> cartListToCartDtoList(List<Cart> cartList);
}
