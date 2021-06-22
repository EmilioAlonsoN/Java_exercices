package com.my_website.web.service;

import com.my_website.web.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> addressList();

    Address findOne(Long id);

    Address addAddress(Address address);

    String deleteAddress(Long id);
}
