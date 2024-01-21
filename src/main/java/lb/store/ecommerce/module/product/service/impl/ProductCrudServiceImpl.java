package lb.store.ecommerce.module.product.service.impl;

import lb.store.ecommerce.common.entity.Category;
import lb.store.ecommerce.common.entity.Image;
import lb.store.ecommerce.common.entity.Product;
import lb.store.ecommerce.common.mapper.ImageMapper;
import lb.store.ecommerce.common.mapper.ProductMapper;
import lb.store.ecommerce.common.repository.CategoryRepository;
import lb.store.ecommerce.common.repository.ProductRepository;
import lb.store.ecommerce.common.service.ImageCrudService;
import lb.store.ecommerce.container.exception.NotFound;
import lb.store.ecommerce.module.product.request.CategoryRequest;
import lb.store.ecommerce.module.product.request.ImageRequest;
import lb.store.ecommerce.module.product.request.ProductRequest;
import lb.store.ecommerce.module.product.response.ProductResponse;
import lb.store.ecommerce.module.product.response.ProductsResponse;
import lb.store.ecommerce.module.product.service.ProductCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCrudServiceImpl implements ProductCrudService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final ImageCrudService imageCrudService;
    private final ImageMapper imageMapper;

    @Override
    public ProductResponse get(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFound("Error.Product.not-found"));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(product).setImageDtoList(imageMapper.imageListToImageDtoList(product.getImages())));
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
        Product saved = productRepository.findById(id).orElseThrow(() -> new NotFound("Error.Product.not-found"));
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
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFound("Error.Product.not-found"));
        List<Category> categories = product.getCategories();
        categories.addAll(categoryRepository.findAllById(request.getCategoryIdList()));
        product.setCategories(new ArrayList<>(new HashSet<>(categories)));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(productRepository.save(product)));
    }

    @Override
    public ProductResponse setCategories(CategoryRequest request, UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFound("Error.Product.not-found"));
        product.setCategories(categoryRepository.findAllById(request.getCategoryIdList()));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(productRepository.save(product)));
    }

    @Override
    public ProductResponse deleteCategories(CategoryRequest request, UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFound("Error.Product.not-found"));
        product.getCategories().removeAll(categoryRepository.findAllById(request.getCategoryIdList()));
        return new ProductResponse().setProductDto(productMapper.productToProductDto(productRepository.save(product)));
    }

    @Override
    public void addImages(List<MultipartFile> request, UUID id) {
        imageCrudService.uploadImages(request, imageList -> {
            Product product = productRepository.findById(id).orElseThrow(() -> new NotFound("Error.Product.not-found"));
            imageList.addAll(product.getImages());
            product.setImages(imageList);
            productRepository.save(product);
        });
    }

    @Override
    public void deleteImages(ImageRequest request, UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFound("Error.Product.not-found"));
        List<Image> images = product.getImages().stream().filter(image -> !request.getImageIdList().contains(image.getId())).collect(Collectors.toList());
        imageCrudService.deleteImages(request.getImageIdList(), () -> {
            product.setImages(images);
            productRepository.save(product);
        });
    }

    @Override
    public void updateMainImage(MultipartFile request, UUID id) {
        imageCrudService.uploadImages(Collections.singletonList(request), imageList -> {
            Product product = productRepository.findById(id).orElseThrow(() -> new NotFound("Error.Product.not-found"));
            Runnable runnable = () -> {
                product.setMainImage(imageList.get(0));
                productRepository.save(product);
            };
            Optional.ofNullable(product.getMainImage())
                    .ifPresentOrElse(image -> imageCrudService.deleteImages(Collections.singletonList(image.getId()), runnable), runnable);
        });
    }

}
