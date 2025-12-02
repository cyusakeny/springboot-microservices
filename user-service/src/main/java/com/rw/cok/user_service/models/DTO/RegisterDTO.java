package com.rw.cok.user_service.models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String phone;
    private String email;
    private String password;
}
