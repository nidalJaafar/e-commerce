package lb.store.bookies.common.mapper;

import lb.store.bookies.common.dto.ProductDto;
import lb.store.bookies.common.entity.Product;
import lb.store.bookies.common.repository.CategoryRepository;
import lb.store.bookies.module.product.request.ProductRequest;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Product mapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class ProductMapper {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Product to product dto.
     *
     * @param product the product
     * @return the product dto
     */
    @Mapping(target = "mainImageDto", source = "mainImage")
    public abstract ProductDto productToProductDto(Product product);

    /**
     * Product list to product dto list.
     *
     * @param products the products
     * @return the list
     */
    public abstract List<ProductDto> productListToProductDtoList(List<Product> products);

    /**
     * Product request to product product.
     *
     * @param request the request
     * @return the product
     */
    public abstract Product productRequestToProduct(ProductRequest request);

    /**
     * Product categories mapping product.
     *
     * @param request the request
     * @param product the product
     * @return the product
     */
    @AfterMapping
    public Product productCategoriesMapping(ProductRequest request, @MappingTarget Product product) {
        return product.setCategories(categoryRepository.findAllById(request.getCategoryIdList()));
    }

    /**
     * Update product from product.
     *
     * @param newProduct   the new product
     * @param savedProduct the saved product
     * @return the product
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Product updateProductFromProduct(Product newProduct, @MappingTarget Product savedProduct);
}
