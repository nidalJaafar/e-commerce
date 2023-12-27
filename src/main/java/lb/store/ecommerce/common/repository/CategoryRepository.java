package lb.store.ecommerce.common.repository;

import lb.store.ecommerce.common.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Category repository.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
