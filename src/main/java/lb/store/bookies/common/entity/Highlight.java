package lb.store.bookies.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Highlight.
 */
@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "product_id"))
public class Highlight extends BaseEntity {
    @OneToOne
    private Product product;
    @OneToOne
    private Image image;
}
