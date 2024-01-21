package lb.store.ecommerce.container.exception.response;

import lombok.Data;

import java.util.List;

@Data
public class ValidationResponse {
    private String message;
    private List<String> errors;
}
