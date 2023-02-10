package lb.store.bookies.config;

import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.batch.BlobBatchAsyncClient;
import com.azure.storage.blob.batch.BlobBatchClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Azure config.
 */
@Configuration
public class AzureConfig {

    /**
     * Blob batch async client.
     *
     * @param containerAsyncClient the container async client
     * @return the blob batch async client
     */
    @Bean
    public BlobBatchAsyncClient blobBatchAsyncClient(BlobContainerAsyncClient containerAsyncClient) {
        return new BlobBatchClientBuilder(containerAsyncClient).buildAsyncClient();
    }

}