package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.dto.request.UserAddressRequest;
import com.raincloud.wash_and_wow.dto.response.UserAddressResponse;
import com.raincloud.wash_and_wow.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
    UserAddress save(UserAddressRequest userAddressRequest, String token);
    List<UserAddressResponse> findAll();
    UserAddress update(UserAddress userAddress);
    Boolean delete(Integer id);
    UserAddressResponse findById(Integer id);
}
