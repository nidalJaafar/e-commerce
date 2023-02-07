package lb.store.bookies.module.highlight.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lb.store.bookies.common.BaseEntity;
import lb.store.bookies.module.product.entity.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "product_id"))
public class Highlight extends BaseEntity {
    @OneToOne
    private Product product;
}
