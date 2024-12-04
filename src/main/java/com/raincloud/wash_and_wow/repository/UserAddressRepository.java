package com.raincloud.wash_and_wow.repository;

import com.raincloud.wash_and_wow.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
}
