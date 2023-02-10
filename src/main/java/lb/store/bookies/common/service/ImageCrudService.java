package lb.store.bookies.common.service;

import lb.store.bookies.common.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface ImageCrudService {
    void uploadImages(List<MultipartFile> files, Consumer<List<Image>> consumer);

    void deleteImages(List<UUID> imageIdList, Runnable runnable);
}
