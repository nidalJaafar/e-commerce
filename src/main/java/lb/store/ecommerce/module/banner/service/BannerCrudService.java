package lb.store.ecommerce.module.banner.service;

import lb.store.ecommerce.module.banner.response.BannerResponse;
import lb.store.ecommerce.module.banner.response.BannersResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface BannerCrudService {
    BannersResponse get();

    BannerResponse get(UUID id);

    void delete(UUID id);

    void post(List<MultipartFile> request);
}
