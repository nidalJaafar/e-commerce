package lb.store.bookies.module.product.service;

import lb.store.bookies.common.repository.ProductRepository;
import lb.store.bookies.module.product.dto.ProductDto;
import lb.store.bookies.module.product.entity.Product;
import lb.store.bookies.module.product.mapper.ProductMapper;
import lb.store.bookies.module.product.request.ProductPostRequest;
import lb.store.bookies.module.product.request.ProductPutRequest;
import lb.store.bookies.module.product.response.ProductResponse;
import lb.store.bookies.module.product.response.ProductsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final  ProductMapper productMapper;
    @Override
    public ProductResponse get(UUID id) {
        Product p = productRepository.findById(id).orElseThrow();
        return new ProductResponse().setProductDto(productMapper.productToProductDto(p));
    }

    @Override
    public ProductsResponse get() {
        List<Product> products = productRepository.findAll();
        return new ProductsResponse().setProductDtoList(productMapper.productListToProductDtoList(products));
    }

    @Override
    public ProductResponse post(ProductPostRequest request) {
        Product p = productRepository.save(productMapper.productPostRequestToProduct(request));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(p));
    }

    @Override
    public ProductResponse put(ProductPutRequest request, UUID id) {
        Product saved = productRepository.findById(id).orElseThrow();
        Product updated = productMapper.updateProductFromProductDto(productMapper.productPutRequestToProductDto(request), saved);
        return new ProductResponse().setProductDto(productMapper.productToProductDto(productRepository.save(updated)));
    }

    @Override
    public void delete(UUID id) {
      productRepository.deleteById(id);
    }
}
