package edu.miu.cs.cs489.lesson7.citylibraryapp.service.impl;

import edu.miu.cs.cs489.lesson7.citylibraryapp.dto.address.AddressResponse2;
import edu.miu.cs.cs489.lesson7.citylibraryapp.dto.publisher.PublisherResponse2;
import edu.miu.cs.cs489.lesson7.citylibraryapp.model.Address;
import edu.miu.cs.cs489.lesson7.citylibraryapp.repository.AddressRepository;
import edu.miu.cs.cs489.lesson7.citylibraryapp.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<AddressResponse2> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(a -> new AddressResponse2(
                        a.getAddressId(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipCode(),
                        new PublisherResponse2(
                                a.getPublisher().getPublisherId(),
                                a.getPublisher().getName()
                        )
                )).toList();
    }

    @Override
    public void deleteAddressById(Integer addressId) {
        addressRepository.deleteById(addressId);
    }


}
