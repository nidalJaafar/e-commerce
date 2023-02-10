package lb.store.bookies.common.repository;

import lb.store.bookies.common.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Image repository.
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {

}
