package lb.store.bookies.common.service.impl;

import com.azure.core.exception.AzureException;
import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobAsyncClient;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.batch.BlobBatchAsyncClient;
import com.azure.storage.blob.models.DeleteSnapshotsOptionType;
import lb.store.bookies.common.entity.Image;
import lb.store.bookies.common.repository.ImageRepository;
import lb.store.bookies.common.service.ImageCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class ImageCrudServiceImpl implements ImageCrudService {

    private final BlobContainerAsyncClient containerAsyncClient;
    private final BlobBatchAsyncClient blobBatchAsyncClient;
    private final ImageRepository imageRepository;

    @Override
    public void uploadImages(List<MultipartFile> files, Consumer<List<Image>> consumer) {
        Flux.fromIterable(files)
                .flatMap(file -> {
                    try {
                        BlobAsyncClient blobAsyncClient = containerAsyncClient.getBlobAsyncClient(getFileName(file));
                        return blobAsyncClient
                                .upload(BinaryData.fromStream(file.getInputStream()), true)
                                .flatMap(blobItem -> Mono.just(new Image().setUrl(blobAsyncClient.getBlobUrl())));
                    } catch (IOException e) {
                        return Flux.error(new AzureException("can't upload image"));
                    }
                })
                .collectList().subscribe(imageList -> consumer.accept(imageRepository.saveAll(imageList)));
    }

    private String getFileName(MultipartFile file) {
        String[] split = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        return split[0] + "--" + UUID.randomUUID() + "." + split[1];
    }

    @Override
    public void deleteImages(List<UUID> imageIdList, Runnable runnable) {
        List<Image> imageList = imageRepository.findAllById(imageIdList);
        runnable.run();
        imageRepository.deleteAllByIdInBatch(imageIdList);
        blobBatchAsyncClient.
                deleteBlobs(imageList.parallelStream().map(Image::getUrl).toList(), DeleteSnapshotsOptionType.INCLUDE)
                .subscribe();
    }

}
