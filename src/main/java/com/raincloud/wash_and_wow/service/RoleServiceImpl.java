package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.entity.Role;
import com.raincloud.wash_and_wow.entity.User;
import com.raincloud.wash_and_wow.repository.RoleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public Role save(@Valid Role role) {
        if (role.getRole() == null || role.getRole().isEmpty()) {
            throw new RuntimeException("Role cannot be empty");
        }
        if (roleRepository.findByRole(role.getRole()).isPresent()) {
            throw new RuntimeException("Role already exists");
        }

        try {
            return roleRepository.save(role);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<Role> findAll() {
        try {
            return roleRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Boolean delete(Integer id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
