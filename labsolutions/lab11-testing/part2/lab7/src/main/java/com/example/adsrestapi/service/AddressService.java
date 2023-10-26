package com.example.adsrestapi.service;

import com.example.adsrestapi.dto.address.AddressPatientResponse;
import com.example.adsrestapi.dto.address.AddressRequest;
import com.example.adsrestapi.dto.address.AddressResponse;
import com.example.adsrestapi.exception.AddressNotFoundException;
import com.example.adsrestapi.model.Address;

import java.util.List;

public interface AddressService {

    List<AddressResponse> getAllAddresses();

    AddressResponse addNewAddress(AddressRequest newAddress);

    AddressResponse getAddressById(Integer addressId) throws AddressNotFoundException;

    AddressResponse updateAddress(AddressRequest addressRequest, int addressId) throws AddressNotFoundException;

    void deleteAddressById(int addressId) throws AddressNotFoundException;

    List<AddressPatientResponse> findAllAddressPatient();


}
