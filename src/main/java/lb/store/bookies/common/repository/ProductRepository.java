package lb.store.bookies.common.repository;

import lb.store.bookies.common.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Product repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
