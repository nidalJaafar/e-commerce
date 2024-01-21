package lb.store.ecommerce.common.repository;

import lb.store.ecommerce.common.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BannerRepository extends JpaRepository<Banner, UUID> {
}
