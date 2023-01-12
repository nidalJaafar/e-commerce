package lb.store.bookies.module.product.service;

import lb.store.bookies.module.product.request.ProductPostRequest;
import lb.store.bookies.module.product.request.ProductPutRequest;
import lb.store.bookies.module.product.response.ProductResponse;
import lb.store.bookies.module.product.response.ProductsResponse;

import java.util.UUID;

public interface ProductService {
    public ProductResponse get(UUID id);
    public ProductsResponse get();
    public ProductResponse post(ProductPostRequest request);
    public ProductResponse put(ProductPutRequest request, UUID id);
    public void delete(UUID id);
}
