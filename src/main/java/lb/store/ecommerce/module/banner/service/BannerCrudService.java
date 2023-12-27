package lb.store.ecommerce.module.banner.service;

import lb.store.ecommerce.module.banner.response.BannerResponse;
import lb.store.ecommerce.module.banner.response.BannersResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * Banner crud service.
 */
public interface BannerCrudService {
    /**
     * Get highlights response.
     *
     * @return the highlights response
     */
    BannersResponse get();

    /**
     * Get banner response.
     *
     * @param id the id
     * @return the banner response
     */
    BannerResponse get(UUID id);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(UUID id);

    /**
     * Update image.
     *
     * @param request the request
     */
    void post(List<MultipartFile> request);
}
