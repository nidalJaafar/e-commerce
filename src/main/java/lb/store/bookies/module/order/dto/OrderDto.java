package lb.store.bookies.module.order.dto;

import lb.store.bookies.common.dto.ProductDto;
import lb.store.bookies.common.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Order dto.
 */
@Data
public class OrderDto implements Serializable {
    private UUID id;
    private Timestamp createdAt;
    private UserDto user;
    private ProductDto product;
    private Long quantity;
}
