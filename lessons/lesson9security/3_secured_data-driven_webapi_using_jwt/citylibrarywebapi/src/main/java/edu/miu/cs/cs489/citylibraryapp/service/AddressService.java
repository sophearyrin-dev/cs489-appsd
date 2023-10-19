package edu.miu.cs.cs489.citylibraryapp.service;

import edu.miu.cs.cs489.citylibraryapp.dto.address.AddressResponse2;
import edu.miu.cs.cs489.citylibraryapp.model.Address;

import java.util.List;

public interface AddressService {

    Address addNewAddress(Address newAddress);
    List<AddressResponse2> getAllAddresses();

    void deleteAddressById(Integer addressId);

}
