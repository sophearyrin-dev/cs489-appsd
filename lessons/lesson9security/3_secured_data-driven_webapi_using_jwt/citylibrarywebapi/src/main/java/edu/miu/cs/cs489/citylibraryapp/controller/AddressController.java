package edu.miu.cs.cs489.citylibraryapp.controller;

import edu.miu.cs.cs489.citylibraryapp.dto.address.AddressResponse2;
import edu.miu.cs.cs489.citylibraryapp.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/citylibrary/api/v1/address/list")
    public ResponseEntity<List<AddressResponse2>> listAddress() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

}
