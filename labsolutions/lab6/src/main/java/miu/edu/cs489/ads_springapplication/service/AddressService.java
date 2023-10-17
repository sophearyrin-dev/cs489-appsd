package miu.edu.cs489.ads_springapplication.service;

import miu.edu.cs489.ads_springapplication.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddresses();

    Address addNewAddress(Address newAddress);
}
