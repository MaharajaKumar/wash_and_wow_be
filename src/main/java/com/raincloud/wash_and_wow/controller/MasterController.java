package com.raincloud.wash_and_wow.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raincloud.wash_and_wow.dto.response.StatusResponse;
import com.raincloud.wash_and_wow.entity.Role;
import com.raincloud.wash_and_wow.entity.ServiceCategory;
import com.raincloud.wash_and_wow.entity.User;
import com.raincloud.wash_and_wow.service.JwtService;
import com.raincloud.wash_and_wow.service.RoleService;
import com.raincloud.wash_and_wow.service.ServiceCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/master")
public class MasterController {

    private final RoleService roleService;
    private final ServiceCategoryService serviceCategoryService;
    private final JwtService jwtService;

    public MasterController(RoleService roleService, ServiceCategoryService serviceCategoryService, JwtService jwtService) {
        this.roleService = roleService;
        this.serviceCategoryService = serviceCategoryService;
        this.jwtService = jwtService;
    }

    @PostMapping("/role")
    public ResponseEntity<StatusResponse> addRole(@RequestBody String requestBody) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(requestBody);
            if (jsonNode.isEmpty()) {
                return ResponseEntity.badRequest().body(StatusResponse.failure("Request body is empty"));
            }
            Role role = mapper.readValue(requestBody, Role.class);
            Role newRole = roleService.save(role);
            return ResponseEntity.ok(StatusResponse.success("Role created successfully"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure(e.getMessage()));
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles() {
        try {
            List<Role> roles = roleService.findAll();
            return ResponseEntity.ok(roles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<StatusResponse> deleteRole(@PathVariable Integer id) {
        try {
            boolean isDeleted = roleService.delete(id);
            if (isDeleted) {
                return ResponseEntity.ok(StatusResponse.success("Role deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(StatusResponse.failure("Role not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure("Deleting role failed: " + e.getMessage()));
        }
    }

    @PostMapping("/service")
    public ResponseEntity<StatusResponse> addServiceCategory(@RequestBody String requestBody) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(requestBody);
            if (jsonNode.isEmpty()) {
                return ResponseEntity.badRequest().body(StatusResponse.failure("Request body is empty"));
            }
            ServiceCategory serviceCategory = mapper.readValue(requestBody, ServiceCategory.class);
            ServiceCategory newServiceCategory = serviceCategoryService.save(serviceCategory);
            return ResponseEntity.ok(StatusResponse.success("Service created successfully"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure(e.getMessage()));
        }
    }

    @GetMapping("/services")
    public ResponseEntity<List<ServiceCategory>> getServiceCategories() {
        try {
            List<ServiceCategory> services = serviceCategoryService.findAll();
            return ResponseEntity.ok(services);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<StatusResponse> deleteServiceCategory(@PathVariable Integer id) {
        try {
            boolean isDeleted = serviceCategoryService.delete(id);
            if (isDeleted) {
                return ResponseEntity.ok(StatusResponse.success("Service deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(StatusResponse.failure("Service not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(StatusResponse.failure("Deleting service failed: " + e.getMessage()));
        }
    }
}
