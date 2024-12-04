package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.entity.ServiceCategory;
import com.raincloud.wash_and_wow.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceCategory save(ServiceCategory serviceCategory) {
        try {
            return serviceRepository.save(serviceCategory);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ServiceCategory> findAll() {
        try {
            return serviceRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            serviceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
