package com.itortosagimeno.ecommerce_api.user.controller;

import com.itortosagimeno.ecommerce_api.exception.model.ApiException;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.user.model.dto.AddressRequest;
import com.itortosagimeno.ecommerce_api.user.model.dto.AddressResponse;
import com.itortosagimeno.ecommerce_api.user.service.AddressService;
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

@Tag(name = "Address", description = "Endpoints for address operations")
@RestController
@RequestMapping("/v1")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Operation(summary = "Retrieve address by user ID", description = "Returns a list of address associated with a specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of address for the user retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @GetMapping("/public/addresses/users/{id}")
    public ResponseEntity<List<AddressResponse>> getAddressByUserId(@PathVariable("id") final Integer userId) {
        final var addresses = addressService.getAddressesByUserId(userId);
        return ResponseEntity.ok(addresses);
    }

    @Operation(summary = "Create a new address", description = "Creates a new address based on the provided address details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Address created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class)))
    })
    @PostMapping("/public/addresses")
    public ResponseEntity<AddressResponse> insertAddress(@Valid @RequestBody final AddressRequest addressRequest) {
        final var address = addressService.insertAddress(addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(address);
    }

    @Operation(summary = "Update address", description = "Update an address based on the provided ID and address details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Address updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @PutMapping("/public/addresses/{id}")
    public ResponseEntity<AddressResponse> updateAddress(
            @PathVariable("id") final Integer id,
            @Valid @RequestBody final AddressRequest addressRequest
    ) {
        final var address = addressService.updateAddress(id, addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(address);
    }

    @Operation(summary = "Delete an address by ID", description = "Deletes an address based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Address deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @GetMapping("/public/addresses/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("id") final Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent()
                .build();
    }
}