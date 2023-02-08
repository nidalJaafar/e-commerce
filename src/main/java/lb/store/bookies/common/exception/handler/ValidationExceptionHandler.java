package lb.store.bookies.common.exception.handler;

import lb.store.bookies.common.exception.response.ValidationResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Validation exception handler.
 */
@RestControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(camelToSnake(error.getField()) + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(camelToSnake(error.getObjectName()) + ": " + error.getDefaultMessage());
        }

        ValidationResponse validationResponse =
                new ValidationResponse().setMessage(ex.getLocalizedMessage()).setErrors(errors);
        return handleExceptionInternal(
                ex, validationResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    private static String camelToSnake(String fieldName) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return fieldName.replaceAll(regex, replacement).toLowerCase();
    }
}
