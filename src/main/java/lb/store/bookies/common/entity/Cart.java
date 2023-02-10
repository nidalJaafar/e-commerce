package lb.store.bookies.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Cart.
 */
@Getter
@Setter
@ToString
@Entity
public class Cart extends BaseEntity {
    @ManyToOne
    private User user;
    @ManyToOne
    @ToString.Exclude
    private Product product;
    private Long quantity;
}
