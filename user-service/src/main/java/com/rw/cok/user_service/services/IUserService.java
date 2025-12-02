package com.rw.cok.user_service.services;

import com.rw.cok.user_service.Exceptions.ResourceNotFoundException;
import com.rw.cok.user_service.models.DTO.AddRolesDTO;
import com.rw.cok.user_service.models.DTO.RegisterDTO;
import com.rw.cok.user_service.models.User;

import java.util.UUID;

public interface IUserService {
    User createUser(RegisterDTO registerDTO);
    User getUserById(UUID id);
    User addRoleToUser(AddRolesDTO dto) throws ResourceNotFoundException;
}
