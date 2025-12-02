package com.rw.cok.user_service.services;

import com.rw.cok.user_service.Exceptions.ResourceNotFoundException;
import com.rw.cok.user_service.models.DTO.AddPermissionDTO;
import com.rw.cok.user_service.models.DTO.RegisterRoleDTO;
import com.rw.cok.user_service.models.Role;

import java.util.List;

public interface IRoleService {
    List<Role> createRole(RegisterRoleDTO registerRoleDTO);
    Role addPermission(AddPermissionDTO addPermissionDTO) throws ResourceNotFoundException;
}
