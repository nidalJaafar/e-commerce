package lb.store.ecommerce.config;

import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.batch.BlobBatchAsyncClient;
import com.azure.storage.blob.batch.BlobBatchClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureConfig {

    @Bean
    public BlobBatchAsyncClient blobBatchAsyncClient(BlobContainerAsyncClient containerAsyncClient) {
        return new BlobBatchClientBuilder(containerAsyncClient).buildAsyncClient();
    }

}