package lb.store.ecommerce.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
    @JoinTable(
            name = "product_category",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    @ToString.Exclude
    private List<Category> categories;
    @OneToOne
    private Image mainImage;
    @OneToMany
    @JoinTable(name = "product_image")
    @ToString.Exclude
    private List<Image> images;
}
