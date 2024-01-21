package lb.store.ecommerce.container.exception.handler;

import lb.store.ecommerce.container.exception.response.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestControllerAdvice
public class DatabaseExceptionHandler {

    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("duplicate key value violates unique constraint", "entry already exists");
        map.put("update or delete on table", "entry in use");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ExceptionResponse alreadyExists(DataIntegrityViolationException e) {
        String message = Objects.requireNonNull(e.getRootCause()).getMessage();
        String exceptionMessage = getExceptionMessage(message);
        return new ExceptionResponse().setMessage(exceptionMessage);
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoSuchElementException.class)
    public ExceptionResponse doesNotExist() {
        return new ExceptionResponse().setMessage("entry not found");
    }

    private String getExceptionMessage(String message) {
        String key = map.keySet().stream().filter(message::contains).findFirst().orElseThrow(() -> new RuntimeException(message));
        return map.get(key);
    }
}
