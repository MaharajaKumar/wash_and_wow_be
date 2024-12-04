package com.raincloud.wash_and_wow.service;

import com.raincloud.wash_and_wow.dto.request.UserAddressRequest;
import com.raincloud.wash_and_wow.dto.response.UserAddressResponse;
import com.raincloud.wash_and_wow.entity.User;
import com.raincloud.wash_and_wow.entity.UserAddress;
import com.raincloud.wash_and_wow.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    private final UserAddressRepository userAddressRepository;
    private final JwtService jwtService;

    public UserAddressServiceImpl(UserAddressRepository userAddressRepository, JwtService jwtService) {
        this.userAddressRepository = userAddressRepository;
        this.jwtService = jwtService;
    }

    @Override
    public UserAddress save(UserAddressRequest userAddressRequest, String token) {
        User user = jwtService.getUserDetailsFromToken(token);
        UserAddress userAddress = new UserAddress();
        userAddress.setDoorNo(userAddressRequest.getDoorNo());
        userAddress.setStreet(userAddressRequest.getStreet());
        userAddress.setArea(userAddressRequest.getArea());
        userAddress.setCity(userAddressRequest.getCity());
        userAddress.setDistrict(userAddressRequest.getDistrict());
        userAddress.setState(userAddressRequest.getState());
        userAddress.setPinCode(userAddressRequest.getPinCode());
        userAddress.setLatitude(userAddressRequest.getLatitude());
        userAddress.setLongitude(userAddressRequest.getLongitude());
        userAddress.setUser(user);

        try {
            return userAddressRepository.save(userAddress);
        } catch (Exception e) {
            throw new RuntimeException("Error saving user address: " + e.getMessage());
        }
    }

    @Override
    public List<UserAddressResponse> findAll() {
        try {
            List<UserAddressResponse> userAddressResponse = new ArrayList<>();
            List<UserAddress> userAddress = userAddressRepository.findAll();
            for (UserAddress address : userAddress) {
                UserAddressResponse response = new UserAddressResponse();
                response.setId(address.getId());
                response.setUser_id(address.getUser().getId());
                response.setDoorNo(address.getDoorNo());
                response.setStreet(address.getStreet());
                response.setArea(address.getArea());
                response.setCity(address.getCity());
                response.setDistrict(address.getDistrict());
                response.setState(address.getState());
                response.setLatitude(address.getLatitude());
                response.setLongitude(address.getLongitude());
                userAddressResponse.add(response);
            }
            return userAddressResponse;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user addresses: " + e.getMessage());
        }
    }

    @Override
    public UserAddressResponse findById(Integer id) {
        try {
            UserAddress userAddress = userAddressRepository.getReferenceById(id);
            UserAddressResponse userAddressResponse = new UserAddressResponse();
            userAddressResponse.setId(userAddress.getId());
            userAddressResponse.setUser_id(userAddress.getUser().getId());
            userAddressResponse.setDoorNo(userAddress.getDoorNo());
            userAddressResponse.setStreet(userAddress.getStreet());
            userAddressResponse.setArea(userAddress.getArea());
            userAddressResponse.setCity(userAddress.getCity());
            userAddressResponse.setDistrict(userAddress.getDistrict());
            userAddressResponse.setState(userAddress.getState());
            userAddressResponse.setLatitude(userAddress.getLatitude());
            userAddressResponse.setLongitude(userAddress.getLongitude());

            return userAddressResponse;

        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user address: " + e.getMessage());
        }
    }

    @Override
    public UserAddress update(UserAddress userAddress) {
        try {
            return userAddressRepository.save(userAddress);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user address: " + e.getMessage());
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            userAddressRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user address: " + e.getMessage());
        }
    }
}

