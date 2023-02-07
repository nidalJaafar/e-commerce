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

/**
 * Order crud controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderCrudController {

    private final OrderCrudService service;

    /**
     * Get order response.
     *
     * @return the order response
     */
    @GetMapping
    public OrderResponse get() {
        return service.get();
    }

    /**
     * Place order.
     *
     * @return the order response
     */
    @GetMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse placeOrder() {
        return service.placeOrder();
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderResponse getAll() {
        return service.getAll();
    }

    /**
     * Gets all by user.
     *
     * @param userId the user id
     * @return the all by user
     */
    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderResponse getAllByUser(@PathVariable UUID userId) {
        return service.getAllByUser(userId);
    }

    /**
     * Delete.
     *
     * @param request the request
     */
    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @RequestBody OrderDeleteRequest request) {
        service.delete(request);
    }

    /**
     * Put order response.
     *
     * @param request the request
     * @return the order response
     */
    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse put(@Valid @RequestBody OrderRequest request) {
        return service.put(request);
    }

}
