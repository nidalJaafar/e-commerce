package lb.store.bookies.module.cart.controller;

import jakarta.validation.Valid;
import lb.store.bookies.module.cart.request.CartRequest;
import lb.store.bookies.module.cart.response.CartResponse;
import lb.store.bookies.module.cart.service.CartCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartCrudController {
    private final CartCrudService service;

    @GetMapping
    public CartResponse get() {
        return service.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse post(@Valid @RequestBody CartRequest request) {
        return service.post(request);
    }

}