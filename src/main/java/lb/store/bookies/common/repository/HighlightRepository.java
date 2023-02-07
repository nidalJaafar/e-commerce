package lb.store.bookies.common.repository;

import lb.store.bookies.common.entity.Highlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Highlight repository.
 */
@Repository
public interface HighlightRepository extends JpaRepository<Highlight, UUID> {
}
