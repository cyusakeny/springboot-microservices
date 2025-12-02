package com.rw.cok.user_service.services.implementations;

import com.rw.cok.user_service.Exceptions.ResourceNotFoundException;
import com.rw.cok.user_service.models.DTO.AddPermissionDTO;
import com.rw.cok.user_service.models.DTO.RegisterRoleDTO;
import com.rw.cok.user_service.models.Permissions;
import com.rw.cok.user_service.models.Role;
import com.rw.cok.user_service.repositories.IPermissionsRepository;
import com.rw.cok.user_service.repositories.IRoleRepository;
import com.rw.cok.user_service.services.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class IRoleServImplementation implements IRoleService {
    private final IRoleRepository roleRepository;
    private final IPermissionsRepository permissionsRepository;
    @Override
    public List<Role> createRole(RegisterRoleDTO registerRoleDTO) {
        List<Role> roles = new ArrayList<>();
        for (String name : registerRoleDTO.getRoles()){
            Role role = new Role();
            role.setName(name);
            roles.add(role);
        }
        return roleRepository.saveAll(roles);
    }

    @Override
    public Role addPermission(AddPermissionDTO addPermissionDTO) throws ResourceNotFoundException {
        Optional<Role> role = roleRepository.findById(addPermissionDTO.getRoleId());
        if (role.isEmpty()) {
            throw new ResourceNotFoundException("Role not found","ROLE_NOT_FOUND");
        }
        List<Permissions> permissions = permissionsRepository.findAllById(addPermissionDTO.getPermissionIds());
        if (permissions.isEmpty()){
            throw new ResourceNotFoundException("Permissions not found","PERMISSION_NOT_FOUND");
        }
        Set<Permissions> permissionSet = new HashSet<>(permissions);
        role.get().setPermissions(permissionSet);
        return roleRepository.save(role.get());
    }
}
