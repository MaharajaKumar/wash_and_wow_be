package com.raincloud.wash_and_wow.repository;

import com.raincloud.wash_and_wow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByCode(String code);
}
