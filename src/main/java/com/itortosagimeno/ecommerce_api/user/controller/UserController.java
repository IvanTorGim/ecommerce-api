package com.itortosagimeno.ecommerce_api.user.controller;

import com.itortosagimeno.ecommerce_api.user.model.UserResponse;
import com.itortosagimeno.ecommerce_api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/private/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        final var users = userService.getAllUsers();
        return ResponseEntity
                .ok(users);
    }
}
