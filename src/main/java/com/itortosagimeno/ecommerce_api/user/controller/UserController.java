package com.itortosagimeno.ecommerce_api.user.controller;

import com.itortosagimeno.ecommerce_api.exception.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.UserRequest;
import com.itortosagimeno.ecommerce_api.user.model.UserResponse;
import com.itortosagimeno.ecommerce_api.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/private/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        final var users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/private/users/{id}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable("id") final Integer id
    ) throws UserNotFoundException {
        final var user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/private/users/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable("id") final Integer id,
            @Valid @RequestBody final UserRequest userRequest
    ) throws UserNotFoundException {
        final var user = userService.updateUser(id, userRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @DeleteMapping("/private/users/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("id") final Integer id
    ) throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
