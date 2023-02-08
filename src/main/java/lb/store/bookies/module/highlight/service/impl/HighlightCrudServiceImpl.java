package lb.store.bookies.module.highlight.service.impl;

import lb.store.bookies.common.repository.HighlightRepository;
import lb.store.bookies.module.highlight.dto.HighlightDto;
import lb.store.bookies.common.entity.Highlight;
import lb.store.bookies.module.highlight.mapper.HighlightMapper;
import lb.store.bookies.module.highlight.request.HighlightRequest;
import lb.store.bookies.module.highlight.response.HighlightResponse;
import lb.store.bookies.module.highlight.response.HighlightsResponse;
import lb.store.bookies.module.highlight.service.HighlightCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Highlight crud service.
 */
@Service
@RequiredArgsConstructor
public class HighlightCrudServiceImpl implements HighlightCrudService {

    private final HighlightRepository highlightRepository;
    private final HighlightMapper highlightMapper;

    @Override
    public HighlightsResponse get() {
        List<HighlightDto> highlightDtoList = highlightMapper.highlightListToHighlightDtoList(highlightRepository.findAll());
        return new HighlightsResponse().setHighlightDtoList(highlightDtoList);
    }

    @Override
    public HighlightResponse get(UUID id) {
        Highlight highlight = highlightRepository.findById(id).orElseThrow();
        return new HighlightResponse().setHighlightDto(highlightMapper.highlightToHighlightDto(highlight));
    }

    @Override
    public HighlightResponse post(HighlightRequest request) {
        Highlight highlight = highlightMapper.highlightRequestToHighlight(request);
        return new HighlightResponse().setHighlightDto(highlightMapper.highlightToHighlightDto(highlightRepository.save(highlight)));
    }

    @Override
    public HighlightResponse put(HighlightRequest request, UUID id) {
        Highlight highlight = highlightRepository.findById(id).orElseThrow();
        Highlight updated = highlightMapper.updateHighlightFromHighlightDto(highlightMapper.highlightToHighlightDto(highlight), highlight);
        return new HighlightResponse().setHighlightDto(highlightMapper.highlightToHighlightDto(highlightRepository.save(updated)));
    }

    @Override
    public void delete(UUID id) {
        try {
            highlightRepository.deleteById(id);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }
}
