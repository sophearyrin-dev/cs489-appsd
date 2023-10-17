package miu.edu.cs489.ads_springapplication.service.imp;

import miu.edu.cs489.ads_springapplication.model.Address;
import miu.edu.cs489.ads_springapplication.repository.AddressRepository;
import miu.edu.cs489.ads_springapplication.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }
}
