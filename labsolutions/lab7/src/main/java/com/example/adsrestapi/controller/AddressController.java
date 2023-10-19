package com.example.adsrestapi.controller;

import com.example.adsrestapi.dto.address.AddressPatientResponse;
import com.example.adsrestapi.dto.address.AddressResponse;
import com.example.adsrestapi.exception.AddressNotFoundException;
import com.example.adsrestapi.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.adsrestapi.dto.address.AddressRequest;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address/")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<AddressResponse>> getAllAddresses(){
//        return ResponseEntity.ok(addressService.getAllAddresses());
//    }


    @PostMapping("/new")
    public ResponseEntity<AddressResponse> addNewAddress(@RequestBody @Valid AddressRequest addressRequest){
        return new ResponseEntity<>(addressService.addNewAddress(addressRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Integer addressId)
    throws AddressNotFoundException {
        return ResponseEntity.ok(addressService.getAddressById(addressId));
    }


    @PutMapping("/update/{addressId}")
    public ResponseEntity<AddressResponse> updateAddressById(@RequestBody AddressRequest addressRequest,
                                                             @PathVariable int addressId) throws AddressNotFoundException{
        return new ResponseEntity<>(addressService.updateAddress(addressRequest,addressId),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable int addressId) throws AddressNotFoundException{
        addressService.deleteAddressById(addressId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AddressPatientResponse>> getAllAddressPatients(){
        return new ResponseEntity<>(addressService.findAllAddressPatient(), HttpStatus.FOUND);
    }




}
