package miu.edu.myelibray.elibrayapp.service;

import miu.edu.myelibray.elibrayapp.model.Address;

import java.util.List;

public interface AddressService {

    Address addNewAddress(Address newAddress);

    List<Address> findAllAddresses();

}
