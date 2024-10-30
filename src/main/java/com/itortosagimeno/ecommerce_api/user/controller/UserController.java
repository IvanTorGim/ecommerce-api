package com.itortosagimeno.ecommerce_api.user.controller;

import com.itortosagimeno.ecommerce_api.user.model.UserRequest;
import com.itortosagimeno.ecommerce_api.user.model.UserResponse;
import com.itortosagimeno.ecommerce_api.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/private/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        final var users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/private/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") final Integer id) {
        final var user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/private/users/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable("id") final Integer id,
            @Valid @RequestBody final UserRequest userRequest
    ) {
        final var user = userService.updateUser(id, userRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }

    @DeleteMapping("/private/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") final Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent()
                .build();
    }
}
