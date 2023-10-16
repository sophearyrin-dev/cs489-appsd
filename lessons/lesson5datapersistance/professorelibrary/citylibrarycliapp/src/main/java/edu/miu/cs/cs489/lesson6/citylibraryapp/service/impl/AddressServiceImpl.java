package edu.miu.cs.cs489.lesson6.citylibraryapp.service.impl;

import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Address;
import edu.miu.cs.cs489.lesson6.citylibraryapp.repository.AddressRepository;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }
}
