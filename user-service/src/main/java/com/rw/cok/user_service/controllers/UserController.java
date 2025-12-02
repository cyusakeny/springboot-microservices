package com.rw.cok.user_service.controllers;

import com.rw.cok.user_service.Exceptions.ResourceNotFoundException;
import com.rw.cok.user_service.models.DTO.AddRolesDTO;
import com.rw.cok.user_service.models.DTO.RegisterDTO;
import com.rw.cok.user_service.models.User;
import com.rw.cok.user_service.services.IUserService;
import com.rw.cok.user_service.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<ApiResponse<User>> addUser(@RequestBody RegisterDTO user) {
        User response = userService.createUser(user);
        return ResponseEntity.ok(new ApiResponse<>(response,"Success","SUCCESS", HttpStatus.CREATED));
    }
    @PostMapping("/addRoles")
    public ResponseEntity<ApiResponse<User>> addRoles(@RequestBody AddRolesDTO dto) throws ResourceNotFoundException {
        User user = userService.addRoleToUser(dto);
        return ResponseEntity.ok(new ApiResponse<>(user,"Success","SUCCESS", HttpStatus.CREATED));
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<ApiResponse<User>> findById(@PathVariable(value = "id") UUID id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(new ApiResponse<>(user,"Success","SUCCESS", HttpStatus.OK));
    }
}
