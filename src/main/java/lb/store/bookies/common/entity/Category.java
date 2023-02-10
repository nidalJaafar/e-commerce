package lb.store.bookies.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Category.
 */
@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category extends BaseEntity {
    private String name;
    @ManyToMany(mappedBy = "categories")
    @ToString.Exclude
    private List<Product> products;
}
