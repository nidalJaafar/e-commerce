package lb.store.ecommerce.module.banner.controller;

import lb.store.ecommerce.module.banner.response.BannerResponse;
import lb.store.ecommerce.module.banner.response.BannersResponse;
import lb.store.ecommerce.module.banner.service.BannerCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * Banner crud controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banner")
public class BannerCrudController {

    private final BannerCrudService service;

    /**
     * Get highlights response.
     *
     * @return the highlights response
     */
    @GetMapping
    public BannersResponse get() {
        return service.get();
    }

    /**
     * Get banner response.
     *
     * @param id the id
     * @return the banner response
     */
    @GetMapping("/{id}")
    public BannerResponse get(@PathVariable UUID id) {
        return service.get(id);
    }


    /**
     * Update image.
     *
     * @param request the request
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void post(@RequestPart("files") List<MultipartFile> request) {
        service.post(request);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
