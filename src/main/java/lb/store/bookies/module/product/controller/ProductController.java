package lb.store.bookies.module.product.controller;

import lb.store.bookies.module.product.request.ProductPostRequest;
import lb.store.bookies.module.product.request.ProductPutRequest;
import lb.store.bookies.module.product.response.ProductResponse;
import lb.store.bookies.module.product.response.ProductsResponse;
import lb.store.bookies.module.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("api/v1/categories")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductsResponse get() {
        return service.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse post(ProductPostRequest request) {
        return service.post(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse put(ProductPutRequest request, @PathVariable UUID id) {
        return service.put(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}
