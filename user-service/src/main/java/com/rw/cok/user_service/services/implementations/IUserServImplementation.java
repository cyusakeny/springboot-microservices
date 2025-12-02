package com.rw.cok.user_service.services.implementations;

import com.rw.cok.user_service.Exceptions.ResourceNotFoundException;
import com.rw.cok.user_service.models.DTO.AddRolesDTO;
import com.rw.cok.user_service.models.DTO.RegisterDTO;
import com.rw.cok.user_service.models.Role;
import com.rw.cok.user_service.models.User;
import com.rw.cok.user_service.repositories.IRoleRepository;
import com.rw.cok.user_service.repositories.IUserRepository;
import com.rw.cok.user_service.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class IUserServImplementation implements IUserService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public User createUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setPhoneNumber(registerDTO.getPhone());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User addRoleToUser(AddRolesDTO dto) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(dto.getUserId());
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User not found","USER_NOT_FOUND");
        }
        List<Role> roles = roleRepository.findAllById(dto.getRoleId());
        if (roles.isEmpty()) {
            throw new ResourceNotFoundException("Role not found","ROLE_NOT_FOUND");
        }
        Set<Role> roleSet = new HashSet<>(roles);
        user.get().setRoles(roleSet);
        return userRepository.save(user.get());
    }
}
