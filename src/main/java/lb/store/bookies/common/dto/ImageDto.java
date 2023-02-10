package lb.store.bookies.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ImageDto implements Serializable {
    private UUID id;
    private String url;
}
