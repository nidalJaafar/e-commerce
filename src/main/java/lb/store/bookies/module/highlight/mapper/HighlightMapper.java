package lb.store.bookies.module.highlight.mapper;

import lb.store.bookies.common.repository.ProductRepository;
import lb.store.bookies.module.highlight.dto.HighlightDto;
import lb.store.bookies.common.entity.Highlight;
import lb.store.bookies.module.highlight.request.HighlightRequest;
import lb.store.bookies.common.entity.Product;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Highlight mapper.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class HighlightMapper {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Highlight to highlight dto.
     *
     * @param highlight the highlight
     * @return the highlight dto
     */
    public abstract HighlightDto highlightToHighlightDto(Highlight highlight);

    /**
     * Highlight list to highlight dto list.
     *
     * @param highlightList the highlight list
     * @return the list
     */
    public abstract List<HighlightDto> highlightListToHighlightDtoList(List<Highlight> highlightList);

    /**
     * Highlight request to highlight.
     *
     * @param highlightRequest the highlight request
     * @return the highlight
     */
    public Highlight highlightRequestToHighlight(HighlightRequest highlightRequest) {
        Product product = productRepository.findById(highlightRequest.getProductId()).orElseThrow();
        return new Highlight().setProduct(product);
    }

    /**
     * Update highlight from highlight dto.
     *
     * @param highlightDto the highlight dto
     * @param highlight    the highlight
     * @return the highlight
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Highlight updateHighlightFromHighlightDto(HighlightDto highlightDto, @MappingTarget Highlight highlight);
}
