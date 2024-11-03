package com.itortosagimeno.ecommerce_api.product.controller;

import com.itortosagimeno.ecommerce_api.exception.model.ApiException;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Orders", description = "Endpoints for orders operations")
@RestController
@RequestMapping("/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Retrieve all orders", description = "Returns a list of all orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of orders retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))
            ),
    })
    @GetMapping("/private/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        final var orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @Operation(summary = "Retrieve orders by address ID", description = "Returns a list of orders associated with a specific address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of orders for the address retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @GetMapping("/public/orders/addresses/{id}")
    public ResponseEntity<List<OrderResponse>> getOrdersByAddressId(@PathVariable("id") final Integer addressId) {
        final var orders = orderService.getOrdersByAddressId(addressId);
        return ResponseEntity.ok(orders);
    }

    @Operation(summary = "Retrieve orders by user ID", description = "Returns a list of orders associated with a specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of orders for the user retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @GetMapping("/public/orders/users/{id}")
    public ResponseEntity<List<OrderResponse>> getOrdersByUserId(@PathVariable("id") final Integer userId) {
        final var orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @Operation(summary = "Retrieve orders by order ID", description = "Returns a the details of a specific order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order for the ID retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @GetMapping("/public/orders/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") final Integer id) {
        final var order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @Operation(summary = "Create a new order", description = "Creates a new order based on the provided order details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @PostMapping("/public/orders")
    public ResponseEntity<OrderResponse> insertOrder(@Valid @RequestBody final OrderRequest orderRequest) {
        final var order = orderService.insertOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(order);
    }

    @Operation(summary = "Delete an order by ID", description = "Deletes an order based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Order deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @DeleteMapping("/public/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") final Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent()
                .build();
    }
}
