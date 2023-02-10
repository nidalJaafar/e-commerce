package lb.store.bookies.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Product.
 */
@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "description"}))
public class Product extends BaseEntity {

    private String name;
    private String description;
    private Long quantity;
    private Double price;
    @ManyToMany
    @ToString.Exclude
    private List<Category> categories;
    @OneToOne
    private Image mainImage;
    @OneToMany
    @ToString.Exclude
    private List<Image> images;
}
