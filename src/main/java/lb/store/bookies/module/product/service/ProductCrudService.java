package lb.store.bookies.module.product.service;

import lb.store.bookies.module.product.request.CategoryRequest;
import lb.store.bookies.module.product.request.ProductRequest;
import lb.store.bookies.module.product.response.ProductResponse;
import lb.store.bookies.module.product.response.ProductsResponse;

import java.util.UUID;

public interface ProductCrudService {
    ProductResponse get(UUID id);

    ProductsResponse get();

    ProductResponse post(ProductRequest request);

    ProductResponse put(ProductRequest request, UUID id);

    void delete(UUID id);

    ProductResponse addCategories(CategoryRequest request, UUID id);

    ProductResponse setCategories(CategoryRequest request, UUID id);

    ProductResponse deleteCategories(CategoryRequest request, UUID id);
}
