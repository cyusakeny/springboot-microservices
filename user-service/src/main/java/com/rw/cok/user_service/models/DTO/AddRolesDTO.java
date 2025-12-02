package com.rw.cok.user_service.models.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AddRolesDTO {
    private UUID userId;
    private List<UUID> roleId;
}
