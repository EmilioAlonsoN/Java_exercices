package com.my_website.web.service.impl;

import com.my_website.web.model.Address;
import com.my_website.web.repository.AddressRepository;
import com.my_website.web.repository.UserRepository;
import com.my_website.web.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Address> addressList() {
        return addressRepository.findAll();
    }

    @Override
    public Address findOne(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public Address addAddress(Address address) {
        address.setUser(userRepository.getById(address.getUserId()));
        return addressRepository.save(address);
    }

    @Override
    public String deleteAddress(Long id) {
        addressRepository.deleteById(id);
        return "{'message': 'User deleted successfully'}";
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
