package com.rw.cok.user_service.services;

import com.rw.cok.user_service.models.DTO.RegisterPermissionDTO;
import com.rw.cok.user_service.models.Permissions;

import java.util.List;

public interface IPermissionService {
    List<Permissions> createPermissions(RegisterPermissionDTO dto);

}
