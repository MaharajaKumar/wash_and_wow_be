package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.entity.User;
import com.raincloud.wash_and_wow.entity.UserPrincipal;
import com.raincloud.wash_and_wow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
        User user = userRepository.findByCode(code);
        if(user == null){
            throw new UsernameNotFoundException("User not found with code " + code);
        }

        return new UserPrincipal(user);
    }
}
