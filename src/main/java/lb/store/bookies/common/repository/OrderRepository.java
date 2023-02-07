package lb.store.bookies.common.repository;

import lb.store.bookies.common.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Order repository.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    /**
     * Find all by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Order> findAllByUserId(UUID userId);
}
