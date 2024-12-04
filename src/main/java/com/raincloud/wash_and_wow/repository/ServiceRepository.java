package com.raincloud.wash_and_wow.repository;

import com.raincloud.wash_and_wow.entity.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ServiceRepository extends JpaRepository<ServiceCategory, Integer> {
}
