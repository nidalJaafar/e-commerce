package lb.store.bookies.module.highlight.service.impl;

import lb.store.bookies.common.entity.Highlight;
import lb.store.bookies.common.repository.HighlightRepository;
import lb.store.bookies.common.service.ImageCrudService;
import lb.store.bookies.module.highlight.dto.HighlightDto;
import lb.store.bookies.module.highlight.mapper.HighlightMapper;
import lb.store.bookies.module.highlight.request.HighlightRequest;
import lb.store.bookies.module.highlight.response.HighlightResponse;
import lb.store.bookies.module.highlight.response.HighlightsResponse;
import lb.store.bookies.module.highlight.service.HighlightCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * Highlight crud service.
 */
@Service
@RequiredArgsConstructor
public class HighlightCrudServiceImpl implements HighlightCrudService {

    private final HighlightRepository highlightRepository;
    private final HighlightMapper highlightMapper;
    private final ImageCrudService imageCrudService;

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

    @Override
    public void updateImage(MultipartFile request, UUID id) {
        imageCrudService.uploadImages(Collections.singletonList(request), imageList -> {
            Highlight highlight = highlightRepository.findById(id).orElseThrow();
            Runnable runnable = () -> {
                highlight.setImage(imageList.get(0));
                highlightRepository.save(highlight);
            };
            Optional.ofNullable(highlight.getImage())
                    .ifPresentOrElse(image -> imageCrudService.deleteImages(Collections.singletonList(image.getId()), runnable), runnable);
        });
    }
}
