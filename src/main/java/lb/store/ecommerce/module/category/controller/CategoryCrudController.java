package lb.store.ecommerce.module.category.controller;

import jakarta.validation.Valid;
import lb.store.ecommerce.module.category.request.CategoryRequest;
import lb.store.ecommerce.module.category.response.CategoriesResponse;
import lb.store.ecommerce.module.category.response.CategoryResponse;
import lb.store.ecommerce.module.category.service.CategoryCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryCrudController {

    private final CategoryCrudService service;

    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping
    public CategoriesResponse get() {
        return service.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryResponse post(@Valid @RequestBody CategoryRequest request) {
        return service.post(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryResponse put(@Valid @RequestBody CategoryRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
