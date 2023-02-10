package lb.store.bookies.module.product.controller;

import jakarta.validation.Valid;
import lb.store.bookies.module.product.request.ImageRequest;
import lb.store.bookies.module.product.request.CategoryRequest;
import lb.store.bookies.module.product.request.ProductRequest;
import lb.store.bookies.module.product.response.ProductResponse;
import lb.store.bookies.module.product.response.ProductsResponse;
import lb.store.bookies.module.product.service.ProductCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * Product crud controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductCrudController {
    private final ProductCrudService service;

    /**
     * Get product response.
     *
     * @param id the id
     * @return the product response
     */
    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    /**
     * Get products response.
     *
     * @return the products response
     */
    @GetMapping
    public ProductsResponse get() {
        return service.get();
    }

    /**
     * Post product response.
     *
     * @param request the request
     * @return the product response
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse post(@Valid @RequestBody ProductRequest request) {
        return service.post(request);
    }

    /**
     * Put product response.
     *
     * @param request the request
     * @param id      the id
     * @return the product response
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse put(@Valid @RequestBody ProductRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    /**
     * Add categories product response.
     *
     * @param request the request
     * @param id      the id
     * @return the product response
     */
    @PutMapping("/category/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse addCategories(@Valid @RequestBody CategoryRequest request, @PathVariable UUID id) {
        return service.addCategories(request, id);
    }

    /**
     * Sets categories.
     *
     * @param request the request
     * @param id      the id
     * @return the categories
     */
    @PutMapping("/category/set/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse setCategories(@Valid @RequestBody CategoryRequest request, @PathVariable UUID id) {
        return service.setCategories(request, id);
    }

    /**
     * Delete categories product response.
     *
     * @param request the request
     * @param id      the id
     * @return the product response
     */
    @PutMapping("/category/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse deleteCategories(@Valid @RequestBody CategoryRequest request, @PathVariable UUID id) {
        return service.deleteCategories(request, id);
    }

    /**
     * Add images.
     *
     * @param request the request
     * @param id      the id
     */
    @PutMapping("/image/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void addImages(@RequestPart("files") List<MultipartFile> request, @PathVariable UUID id) {
        service.addImages(request, id);
    }

    /**
     * Delete images.
     *
     * @param request the request
     * @param id      the id
     */
    @PutMapping("/image/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteImages(@Valid @RequestBody ImageRequest request, @PathVariable UUID id) {
        service.deleteImages(request, id);
    }

    /**
     * Update main image.
     *
     * @param request the request
     * @param id      the id
     */
    @PutMapping("/image/main/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void updateMainImage(@RequestPart("file") MultipartFile request, @PathVariable UUID id) {
        service.updateMainImage(request, id);
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
