package lb.store.ecommerce.module.order.dto;

import lb.store.ecommerce.common.dto.ProductDto;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class OrderDto implements Serializable {
    private UUID id;
    private Timestamp createdAt;
    private UUID userId;
    private ProductDto product;
    private Long quantity;
}
