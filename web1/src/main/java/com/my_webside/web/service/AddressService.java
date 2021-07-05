package com.my_webside.web.service;

import com.my_webside.web.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> addressList();

    Address findOne(Long id);

    Address addAddress(Address address);

    String deleteAddress(Long id);
}
