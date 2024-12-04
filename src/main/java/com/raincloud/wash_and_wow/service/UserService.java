package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.dto.request.UserRegistrationRequest;
import com.raincloud.wash_and_wow.dto.response.UserResponse;
import com.raincloud.wash_and_wow.entity.User;

import java.util.List;

public interface UserService {
    User save(UserRegistrationRequest userRequest);
    String verify(User user);
    UserResponse findById(Integer id);
    Boolean delete(Integer id);
    List<UserResponse> findAll();
}
