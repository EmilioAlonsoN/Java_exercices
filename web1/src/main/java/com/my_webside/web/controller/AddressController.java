package com.my_webside.web.controller;

import com.my_webside.web.model.Address;
import com.my_webside.web.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        return addressService.deleteAddress(id);
    }

    @RequestMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @RequestMapping("/list/{id}")
    public Address findOne(@PathVariable Long id) {
        return addressService.findOne(id);
    }

    @RequestMapping("/list")
    public List<Address> addressList() {
        return addressService.addressList();
    }
}
