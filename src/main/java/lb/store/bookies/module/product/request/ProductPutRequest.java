package lb.store.bookies.module.product.request;

import lombok.Data;

@Data
public class ProductPutRequest {
    private  String name;
    private  String description;
    private  Long quantity;
    private  Double price;
}
