package com.rw.cok.user_service.services.implementations;

import com.rw.cok.user_service.models.DTO.RegisterPermissionDTO;
import com.rw.cok.user_service.models.Permissions;
import com.rw.cok.user_service.models.Role;
import com.rw.cok.user_service.repositories.IPermissionsRepository;
import com.rw.cok.user_service.services.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IPermissionServImplementation implements IPermissionService {
    private final IPermissionsRepository permissionsRepository;
    @Override
    public List<Permissions> createPermissions(RegisterPermissionDTO dto) {
        List<Permissions> permissions = new ArrayList<>();
        for (String name : dto.getPermissions()) {
            Permissions permission = new Permissions();
            permission.setName(name);
            permissions.add(permission);
        }
        return permissionsRepository.saveAll(permissions);
    }
}
