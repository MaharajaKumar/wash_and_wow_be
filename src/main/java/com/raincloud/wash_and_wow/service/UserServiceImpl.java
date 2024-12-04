package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.dto.request.UserRegistrationRequest;
import com.raincloud.wash_and_wow.dto.response.UserResponse;
import com.raincloud.wash_and_wow.entity.User;
import com.raincloud.wash_and_wow.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User save(UserRegistrationRequest userRequest) {
        try {
            User user = new User();
            user.setCode(userRequest.getCode());
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setDob(userRequest.getDob());
            user.setMobileNumber(userRequest.getMobileNumber());
            user.setEmail(userRequest.getEmail());
            user.setPassword(encoder.encode(userRequest.getPassword()));
            if (Objects.equals(userRequest.getRole(), "") || Objects.equals(userRequest.getRole(), null)) {
                user.setRole("CUSTOMER");
            } else {
                user.setRole(userRequest.getRole());
            }
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String verify(User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getCode(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(user.getCode());
            }
            return "Failed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Failed";
        }
    }

    @Override
    public UserResponse findById(Integer id) {
        try {
            User user = userRepository.getReferenceById(id);
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setCode(user.getCode());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setDob(user.getDob());
            userResponse.setRole(user.getRole());
            userResponse.setMobileNumber(user.getMobileNumber());
            userResponse.setEmail(user.getEmail());
            return userResponse;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No user found with ID: " + id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user: " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<UserResponse> findAll() {
        try {
            List<User> usersList = userRepository.findAll();
            List<UserResponse> userResponseList = new ArrayList<>();
            for (User user : usersList) {
                UserResponse userResponse = new UserResponse();
                userResponse.setId(user.getId());
                userResponse.setCode(user.getCode());
                userResponse.setFirstName(user.getFirstName());
                userResponse.setLastName(user.getLastName());
                userResponse.setDob(user.getDob());
                userResponse.setRole(user.getRole());
                userResponse.setMobileNumber(user.getMobileNumber());
                userResponse.setEmail(user.getEmail());
                userResponseList.add(userResponse);
            }
            return userResponseList;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}