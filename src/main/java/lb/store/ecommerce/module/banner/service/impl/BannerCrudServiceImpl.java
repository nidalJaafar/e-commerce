package lb.store.ecommerce.module.banner.service.impl;

import lb.store.ecommerce.common.entity.Banner;
import lb.store.ecommerce.common.repository.BannerRepository;
import lb.store.ecommerce.common.service.ImageCrudService;
import lb.store.ecommerce.module.banner.dto.BannerDto;
import lb.store.ecommerce.module.banner.mapper.BannerMapper;
import lb.store.ecommerce.module.banner.response.BannerResponse;
import lb.store.ecommerce.module.banner.response.BannersResponse;
import lb.store.ecommerce.module.banner.service.BannerCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Banner crud service.
 */
@Service
@RequiredArgsConstructor
public class BannerCrudServiceImpl implements BannerCrudService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;
    private final ImageCrudService imageCrudService;

    @Override
    public BannersResponse get() {
        List<BannerDto> bannerDtoList = bannerMapper.bannerListToBannerDtoList(bannerRepository.findAll());
        return new BannersResponse().setBannerDtoList(bannerDtoList);
    }

    @Override
    public BannerResponse get(UUID id) {
        Banner banner = bannerRepository.findById(id).orElseThrow();
        return new BannerResponse().setBannerDto(bannerMapper.bannerToBannerDto(banner));
    }

    @Override
    public void delete(UUID id) {
        try {
            bannerRepository.deleteById(id);
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void post(List<MultipartFile> request) {
        imageCrudService.uploadImages(request, imageList -> {
            List<Banner> banners = new ArrayList<>(imageList.size());
            imageList.forEach(image -> banners.add(new Banner().setImage(image)));
            bannerRepository.saveAll(banners);
        });
    }
}
