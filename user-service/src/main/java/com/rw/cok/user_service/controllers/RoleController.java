package com.rw.cok.user_service.controllers;

import com.rw.cok.user_service.models.DTO.RegisterRoleDTO;
import com.rw.cok.user_service.models.Role;
import com.rw.cok.user_service.services.IRoleService;
import com.rw.cok.user_service.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService roleService;
    @PostMapping("/addRole")
    public ResponseEntity<ApiResponse<List<Role>>> addRole(@RequestBody RegisterRoleDTO role) {
        List<Role> roles = roleService.createRole(role);
        return ResponseEntity.ok(new ApiResponse<>(roles,"","", HttpStatus.CREATED));
    }
}
