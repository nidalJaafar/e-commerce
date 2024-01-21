package lb.store.ecommerce.module.product.service;

import lb.store.ecommerce.module.product.request.CategoryRequest;
import lb.store.ecommerce.module.product.request.ImageRequest;
import lb.store.ecommerce.module.product.request.ProductRequest;
import lb.store.ecommerce.module.product.response.ProductResponse;
import lb.store.ecommerce.module.product.response.ProductsResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
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

    void addImages(List<MultipartFile> request, UUID id);

    void deleteImages(ImageRequest request, UUID id);

    void updateMainImage(MultipartFile request, UUID id);

}
