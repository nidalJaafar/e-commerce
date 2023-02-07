package lb.store.bookies.common.repository;

import lb.store.bookies.module.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
    List<Cart> findAllByUserId(UUID userId);

    Optional<Cart> findByUserIdAndProductId(UUID userId, UUID productId);
}
