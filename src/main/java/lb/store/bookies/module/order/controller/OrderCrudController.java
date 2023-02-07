package lb.store.bookies.module.order.controller;

import jakarta.validation.Valid;
import lb.store.bookies.module.order.request.OrderDeleteRequest;
import lb.store.bookies.module.order.request.OrderRequest;
import lb.store.bookies.module.order.response.OrderResponse;
import lb.store.bookies.module.order.service.OrderCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderCrudController {

    private final OrderCrudService service;

    @GetMapping
    public OrderResponse get() {
        return service.get();
    }

    @GetMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse placeOrder() {
        return service.placeOrder();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderResponse getAll() {
        return service.getAll();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderResponse getAllByUser(@PathVariable UUID userId) {
        return service.getAllByUser(userId);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @RequestBody OrderDeleteRequest request) {
        service.delete(request);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse put(@Valid @RequestBody OrderRequest request) {
        return service.put(request);
    }

}
