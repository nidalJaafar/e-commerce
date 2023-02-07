package lb.store.bookies.module.highlight.mapper;

import lb.store.bookies.common.repository.ProductRepository;
import lb.store.bookies.module.highlight.dto.HighlightDto;
import lb.store.bookies.module.highlight.entity.Highlight;
import lb.store.bookies.module.highlight.request.HighlightRequest;
import lb.store.bookies.module.product.entity.Product;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class HighlightMapper {
    @Autowired
    private ProductRepository productRepository;

    public abstract HighlightDto highlightToHighlightDto(Highlight highlight);

    public abstract List<HighlightDto> highlightListToHighlightDtoList(List<Highlight> highlightList);

    public Highlight highlightRequestToHighlight(HighlightRequest highlightRequest) {
        Product product = productRepository.findById(highlightRequest.getProductId()).orElseThrow();
        return new Highlight().setProduct(product);
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Highlight updateHighlightFromHighlightDto(HighlightDto highlightDto, @MappingTarget Highlight highlight);
}
