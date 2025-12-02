package com.rw.cok.user_service.controllers;

import com.rw.cok.user_service.models.DTO.RegisterPermissionDTO;
import com.rw.cok.user_service.models.Permissions;
import com.rw.cok.user_service.services.IPermissionService;
import com.rw.cok.user_service.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Permission;
import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {
    private final IPermissionService permissionService;
    @PostMapping("/addPermission")
    public ResponseEntity<ApiResponse<List<Permissions>>> addPermission(@RequestBody RegisterPermissionDTO permission) {
        List<Permissions> permissions = permissionService.createPermissions(permission);
        return ResponseEntity.ok(new ApiResponse<>(permissions,"Permissions","PERMISSIONS_CREATED", HttpStatus.CREATED));
    }
}
