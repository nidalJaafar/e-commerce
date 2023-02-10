package lb.store.bookies.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Order.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @OneToOne
    private User user;
    @ManyToOne
    private Product product;
    private Long quantity;
}
