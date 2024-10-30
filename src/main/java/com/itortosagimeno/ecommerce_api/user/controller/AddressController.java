package com.itortosagimeno.ecommerce_api.user.controller;

import com.itortosagimeno.ecommerce_api.user.model.dto.AddressRequest;
import com.itortosagimeno.ecommerce_api.user.model.dto.AddressResponse;
import com.itortosagimeno.ecommerce_api.user.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/public/addresses/users/{id}")
    public ResponseEntity<List<AddressResponse>> getAddressByUserId(@PathVariable("id") final Integer userId) {
        final var addresses = addressService.getAddressesByUserId(userId);
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("/public/addresses")
    public ResponseEntity<AddressResponse> insertAddress(@Valid @RequestBody final AddressRequest addressRequest) {
        final var address = addressService.insertAddress(addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(address);
    }

    @PutMapping("/public/addresses/{id}")
    public ResponseEntity<AddressResponse> updateAddress(
            @PathVariable("id") final Integer id,
            @Valid @RequestBody final AddressRequest addressRequest
    ) {
        final var address = addressService.updateAddress(id, addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(address);
    }

    @GetMapping("/public/addresses/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("id") final Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent()
                .build();
    }
}