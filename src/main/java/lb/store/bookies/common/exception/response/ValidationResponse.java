package lb.store.bookies.common.exception.response;

import lombok.Data;

import java.util.List;

/**
 * Validation response.
 */
@Data
public class ValidationResponse {
    private String message;
    private List<String> errors;
}
