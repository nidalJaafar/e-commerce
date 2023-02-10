package lb.store.bookies.common.service;

import lb.store.bookies.common.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Image crud service.
 */
public interface ImageCrudService {
    /**
     * Upload images.
     *
     * @param files    the files
     * @param consumer the consumer
     */
    void uploadImages(List<MultipartFile> files, Consumer<List<Image>> consumer);

    /**
     * Delete images.
     *
     * @param imageIdList the image id list
     * @param runnable    the runnable
     */
    void deleteImages(List<UUID> imageIdList, Runnable runnable);
}
