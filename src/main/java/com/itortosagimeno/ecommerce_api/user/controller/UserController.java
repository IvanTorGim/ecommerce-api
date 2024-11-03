package com.itortosagimeno.ecommerce_api.user.controller;

import com.itortosagimeno.ecommerce_api.exception.model.ApiException;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.user.model.dto.UserRequest;
import com.itortosagimeno.ecommerce_api.user.model.dto.UserResponse;
import com.itortosagimeno.ecommerce_api.user.service.UserService;
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

@Tag(name = "Users", description = "Endpoints for users operations")
@RestController
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Retrieve all users", description = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of users retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))
            ),
    })
    @GetMapping("/private/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        final var users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Retrieve users by user ID", description = "Returns a the details of a specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User for the ID retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @GetMapping("/private/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") final Integer id) {
        final var user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Update user", description = "Update an user based on the provided ID and user details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @PutMapping("/private/users/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable("id") final Integer id,
            @Valid @RequestBody final UserRequest userRequest
    ) {
        final var user = userService.updateUser(id, userRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }

    @Operation(summary = "Delete an user by ID", description = "Deletes an user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @DeleteMapping("/private/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") final Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent()
                .build();
    }
}
