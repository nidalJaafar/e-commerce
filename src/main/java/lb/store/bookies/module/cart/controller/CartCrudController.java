package lb.store.bookies.module.cart.controller;

import jakarta.validation.Valid;
import lb.store.bookies.module.cart.request.CartRequest;
import lb.store.bookies.module.cart.response.CartResponse;
import lb.store.bookies.module.cart.service.CartCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Cart crud controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartCrudController {
    private final CartCrudService service;

    /**
     * Get cart response.
     *
     * @return the cart response
     */
    @GetMapping
    public CartResponse get() {
        return service.get();
    }

    /**
     * Post cart response.
     *
     * @param request the request
     * @return the cart response
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse post(@Valid @RequestBody CartRequest request) {
        return service.post(request);
    }

}
