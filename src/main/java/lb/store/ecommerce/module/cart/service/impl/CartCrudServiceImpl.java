package lb.store.ecommerce.module.cart.service.impl;

import lb.store.ecommerce.common.entity.Cart;
import lb.store.ecommerce.common.entity.Product;
import lb.store.ecommerce.common.entity.User;
import lb.store.ecommerce.common.mapper.CartMapper;
import lb.store.ecommerce.common.repository.CartRepository;
import lb.store.ecommerce.common.repository.ProductRepository;
import lb.store.ecommerce.common.util.AuthenticatedUser;
import lb.store.ecommerce.module.cart.request.CartRequest;
import lb.store.ecommerce.module.cart.response.CartResponse;
import lb.store.ecommerce.module.cart.service.CartCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Cart crud service.
 */
@Service
@RequiredArgsConstructor
public class CartCrudServiceImpl implements CartCrudService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    @Override
    public CartResponse post(CartRequest request) {
        User authenticatedUser = AuthenticatedUser.getAuthenticatedUser();
        Optional<Cart> cartOptional = cartRepository.findByUserIdAndProductId(authenticatedUser.getId(), request.getProductId());
        cartOptional.ifPresentOrElse(cart -> {
            cart.setQuantity(request.getQuantity());
            cartRepository.save(cart);
        }, () -> {
            Product product = productRepository.findById(request.getProductId()).orElseThrow();
            Cart cart = new Cart().setQuantity(request.getQuantity()).setUser(authenticatedUser).setProduct(product);
            cartRepository.save(cart);
        });
        return new CartResponse().setCartDtoList(cartMapper.cartListToCartDtoList(cartRepository.findAllByUserId(authenticatedUser.getId())));
    }

    @Override
    public CartResponse get() {
        List<Cart> cartList = cartRepository.findAllByUserId(AuthenticatedUser.getAuthenticatedUser().getId());
        return new CartResponse().setCartDtoList(cartMapper.cartListToCartDtoList(cartList));
    }
}
