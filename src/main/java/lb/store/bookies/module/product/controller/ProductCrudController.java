package lb.store.bookies.module.product.controller;

import jakarta.validation.Valid;
import lb.store.bookies.module.product.request.CategoryRequest;
import lb.store.bookies.module.product.request.ProductRequest;
import lb.store.bookies.module.product.response.ProductResponse;
import lb.store.bookies.module.product.response.ProductsResponse;
import lb.store.bookies.module.product.service.ProductCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductCrudController {
    private final ProductCrudService service;

    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping
    public ProductsResponse get() {
        return service.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse post(@Valid @RequestBody ProductRequest request) {
        return service.post(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse put(@Valid @RequestBody ProductRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    @PutMapping("/category/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse addCategories(@Valid @RequestBody CategoryRequest request, @PathVariable UUID id) {
        return service.addCategories(request, id);
    }

    @PutMapping("/category/set/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse setCategories(@Valid @RequestBody CategoryRequest request, @PathVariable UUID id) {
        return service.setCategories(request, id);
    }

    @PutMapping("/category/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse deleteCategories(@Valid @RequestBody CategoryRequest request, @PathVariable UUID id) {
        return service.deleteCategories(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}