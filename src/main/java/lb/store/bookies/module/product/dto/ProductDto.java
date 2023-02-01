package lb.store.bookies.module.product.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private  String name;
    private  String description;
    private  Long quantity;
    private  Double price;
    private  String image;
}
