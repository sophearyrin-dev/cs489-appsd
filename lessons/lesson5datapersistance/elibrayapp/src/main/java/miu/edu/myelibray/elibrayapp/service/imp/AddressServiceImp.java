package miu.edu.myelibray.elibrayapp.service.imp;

import miu.edu.myelibray.elibrayapp.model.Address;
import miu.edu.myelibray.elibrayapp.repository.AddressRepository;
import miu.edu.myelibray.elibrayapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }
}
