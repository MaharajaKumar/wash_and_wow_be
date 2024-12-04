package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.entity.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);
    List<Role> findAll();
    Boolean delete(Integer id);
}
