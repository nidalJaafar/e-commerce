package lb.store.bookies.module.product.service.impl;

import lb.store.bookies.common.repository.CategoryRepository;
import lb.store.bookies.common.repository.ProductRepository;
import lb.store.bookies.module.category.entity.Category;
import lb.store.bookies.module.product.entity.Product;
import lb.store.bookies.module.product.mapper.ProductMapper;
import lb.store.bookies.module.product.request.CategoryRequest;
import lb.store.bookies.module.product.request.ProductRequest;
import lb.store.bookies.module.product.response.ProductResponse;
import lb.store.bookies.module.product.response.ProductsResponse;
import lb.store.bookies.module.product.service.ProductCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductCrudServiceImpl implements ProductCrudService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse get(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        return new ProductResponse().setProductDto(productMapper.productToProductDto(product));
    }

    @Override
    public ProductsResponse get() {
        List<Product> products = productRepository.findAll();
        return new ProductsResponse().setProductDtoList(productMapper.productListToProductDtoList(products));
    }

    @Override
    public ProductResponse post(ProductRequest request) {
        Product p = productRepository.save(productMapper.productRequestToProduct(request));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(p));
    }

    @Override
    public ProductResponse put(ProductRequest request, UUID id) {
        Product saved = productRepository.findById(id).orElseThrow();
        Product updated = productMapper.updateProductFromProduct(productMapper.productRequestToProduct(request), saved);
        return new ProductResponse().setProductDto(productMapper.productToProductDto(productRepository.save(updated)));
    }

    @Override
    public void delete(UUID id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public ProductResponse addCategories(CategoryRequest request, UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        List<Category> categories = product.getCategories();
        categories.addAll(categoryRepository.findAllById(request.getCategoryIdList()));
        product.setCategories(new ArrayList<>(new HashSet<>(categories)));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(productRepository.save(product)));
    }

    @Override
    public ProductResponse setCategories(CategoryRequest request, UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setCategories(categoryRepository.findAllById(request.getCategoryIdList()));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(productRepository.save(product)));
    }

    @Override
    public ProductResponse deleteCategories(CategoryRequest request, UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.getCategories().removeAll(categoryRepository.findAllById(request.getCategoryIdList()));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(productRepository.save(product)));
    }
}
