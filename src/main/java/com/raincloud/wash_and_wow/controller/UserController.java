package com.raincloud.wash_and_wow.controller;

import com.raincloud.wash_and_wow.dto.request.LoginRequest;
import com.raincloud.wash_and_wow.dto.request.UserAddressRequest;
import com.raincloud.wash_and_wow.dto.request.UserRegistrationRequest;
import com.raincloud.wash_and_wow.dto.response.StatusResponse;
import com.raincloud.wash_and_wow.dto.response.UserAddressResponse;
import com.raincloud.wash_and_wow.dto.response.UserResponse;
import com.raincloud.wash_and_wow.entity.User;
import com.raincloud.wash_and_wow.entity.UserAddress;
import com.raincloud.wash_and_wow.handlers.BusinessException;
import com.raincloud.wash_and_wow.service.UserAddressService;
import com.raincloud.wash_and_wow.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserAddressService userAddressService;

    public UserController(UserService userService, UserAddressService userAddressService) {
        this.userService = userService;
        this.userAddressService = userAddressService;
    }

    @PostMapping("/register")
    public ResponseEntity<StatusResponse> addUser(@Valid @RequestBody UserRegistrationRequest requestBody) {
        try {
            User savedUser = userService.save(requestBody);
            return ResponseEntity.ok(StatusResponse.success("User registered successfully"));
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(StatusResponse.failure(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure("User registration failed: " + e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<StatusResponse> login(@Valid @RequestBody LoginRequest authRequest) {
        try {
            User user = new User();
            user.setCode(authRequest.getCode());
            user.setPassword(authRequest.getPassword());
            String token = userService.verify(user);
            if ("Failed".equals(token)) {
                return ResponseEntity.ok(StatusResponse.failure("Invalid User"));
            }
            return ResponseEntity.ok(StatusResponse.authorized("Logged in successfully", token));
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(StatusResponse.failure(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure(e.getMessage()));
        }
    }

    @GetMapping("/users")
    public ResponseEntity<StatusResponse> getUser(@RequestParam(name = "id", required = false) Integer id) {
        try {
            if (id != null) {
                UserResponse user = userService.findById(id);
                return ResponseEntity.ok(StatusResponse.data(user));
            } else {
                List<UserResponse> users = userService.findAll();
                return ResponseEntity.ok(StatusResponse.data(users));
            }
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(StatusResponse.failure(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure("Fetch user failed: " + e.getMessage()));
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<StatusResponse> deleteUser(@RequestParam(name = "id") Integer id) {
        try {
            boolean isDeleted = userService.delete(id);
            if (isDeleted) {
                return ResponseEntity.ok(StatusResponse.success("User deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(StatusResponse.failure("User not found"));
            }
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(StatusResponse.failure(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure("Deleting user failed: " + e.getMessage()));
        }
    }

    @PostMapping("/addresses")
    public ResponseEntity<StatusResponse> addUserAddress(@RequestHeader("Authorization") String token, @RequestParam(name = "id", required = false) Integer id, @Valid @RequestBody UserAddressRequest requestBody) {
        try {
            UserAddress userAddress = userAddressService.save(requestBody, token);
            return ResponseEntity.ok(StatusResponse.success("User address added successfully"));
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(StatusResponse.failure(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure("Adding user address failed: " + e.getMessage()));
        }
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<StatusResponse> getUserAddresses(@PathVariable Integer id) {
        try {
            if (id != null) {
                UserAddressResponse userAddressResponse = userAddressService.findById(id);
                return ResponseEntity.ok(StatusResponse.data(userAddressResponse));
            } else {
                List<UserAddressResponse> addresses = userAddressService.findAll();
                return ResponseEntity.ok(StatusResponse.data(addresses));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure(e.getMessage()));
        }
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<StatusResponse> deleteUserAddress(@PathVariable Integer id) {
        try {
            boolean isDeleted = userAddressService.delete(id);
            if (isDeleted) {
                return ResponseEntity.ok(StatusResponse.success("User address deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(StatusResponse.failure("User address not found"));
            }
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(StatusResponse.failure(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure("Deleting user address failed: " + e.getMessage()));
        }
    }
}
