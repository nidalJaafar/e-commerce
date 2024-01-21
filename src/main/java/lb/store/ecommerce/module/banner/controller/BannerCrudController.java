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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banner")
public class BannerCrudController {

    private final BannerCrudService service;

    @GetMapping
    public BannersResponse get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public BannerResponse get(@PathVariable UUID id) {
        return service.get(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void post(@RequestPart("files") List<MultipartFile> request) {
        service.post(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
