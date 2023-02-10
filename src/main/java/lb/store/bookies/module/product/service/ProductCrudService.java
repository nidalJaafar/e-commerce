package lb.store.bookies.module.product.service;

import lb.store.bookies.module.product.request.ImageRequest;
import lb.store.bookies.module.product.request.CategoryRequest;
import lb.store.bookies.module.product.request.ProductRequest;
import lb.store.bookies.module.product.response.ProductResponse;
import lb.store.bookies.module.product.response.ProductsResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * Product crud service.
 */
public interface ProductCrudService {
    /**
     * Get product response.
     *
     * @param id the id
     * @return the product response
     */
    ProductResponse get(UUID id);

    /**
     * Get products response.
     *
     * @return the products response
     */
    ProductsResponse get();

    /**
     * Post product response.
     *
     * @param request the request
     * @return the product response
     */
    ProductResponse post(ProductRequest request);

    /**
     * Put product response.
     *
     * @param request the request
     * @param id      the id
     * @return the product response
     */
    ProductResponse put(ProductRequest request, UUID id);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(UUID id);

    /**
     * Add categories product response.
     *
     * @param request the request
     * @param id      the id
     * @return the product response
     */
    ProductResponse addCategories(CategoryRequest request, UUID id);

    /**
     * Sets categories.
     *
     * @param request the request
     * @param id      the id
     * @return the categories
     */
    ProductResponse setCategories(CategoryRequest request, UUID id);

    /**
     * Delete categories product response.
     *
     * @param request the request
     * @param id      the id
     * @return the product response
     */
    ProductResponse deleteCategories(CategoryRequest request, UUID id);

    /**
     * Add images.
     *
     * @param request the request
     * @param id      the id
     */
    void addImages(List<MultipartFile> request, UUID id);

    /**
     * Delete images.
     *
     * @param request the request
     * @param id      the id
     */
    void deleteImages(ImageRequest request, UUID id);

    /**
     * Update main image.
     *
     * @param request the request
     * @param id      the id
     */
    void updateMainImage(MultipartFile request, UUID id);

}
