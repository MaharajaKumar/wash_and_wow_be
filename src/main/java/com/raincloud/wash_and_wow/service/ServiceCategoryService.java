package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.entity.ServiceCategory;

import java.util.List;

public interface ServiceCategoryService {
    ServiceCategory save(ServiceCategory role);
    List<ServiceCategory> findAll();
    Boolean delete(Integer id);
}
