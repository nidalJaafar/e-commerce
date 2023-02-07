package lb.store.bookies.common.repository;

import lb.store.bookies.common.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Cart repository.
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
    /**
     * Find all by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Cart> findAllByUserId(UUID userId);

    /**
     * Find by user id and product id optional.
     *
     * @param userId    the user id
     * @param productId the product id
     * @return the optional
     */
    Optional<Cart> findByUserIdAndProductId(UUID userId, UUID productId);
}
