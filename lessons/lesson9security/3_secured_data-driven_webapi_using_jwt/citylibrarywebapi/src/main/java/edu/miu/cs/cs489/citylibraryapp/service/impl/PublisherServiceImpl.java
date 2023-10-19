package edu.miu.cs.cs489.citylibraryapp.service.impl;

import edu.miu.cs.cs489.citylibraryapp.dto.address.AddressResponse;
import edu.miu.cs.cs489.citylibraryapp.dto.publisher.PublisherRequest;
import edu.miu.cs.cs489.citylibraryapp.dto.publisher.PublisherResponse;
import edu.miu.cs.cs489.citylibraryapp.exception.PublisherNotFoundException;
import edu.miu.cs.cs489.citylibraryapp.model.Address;
import edu.miu.cs.cs489.citylibraryapp.model.Publisher;
import edu.miu.cs.cs489.citylibraryapp.repository.AddressRepository;
import edu.miu.cs.cs489.citylibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs489.citylibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

//    @Autowired
    private PublisherRepository publisherRepository;
    private AddressRepository addressRepository;

//    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository,
                                AddressRepository addressRepository) {
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

//    public PublisherServiceImpl() {
//
//    }

    @Override
    public List<PublisherResponse> getAllPublishers() {
        return publisherRepository.findAll(Sort.by("name"))
                .stream()
//                .sorted(Comparator.comparing(Publisher::getName))
                .map(p -> new PublisherResponse(
                        p.getPublisherId(),
                        p.getName(),
                        (p.getPrimaryAddress()!=null)?new AddressResponse(
                                p.getPrimaryAddress().getAddressId(),
                                p.getPrimaryAddress().getStreet(),
                                p.getPrimaryAddress().getCity(),
                                p.getPrimaryAddress().getState(),
                                p.getPrimaryAddress().getZipCode()
                        ):null
                )).toList();
    }

    @Override
    public PublisherResponse addNewPublisher(PublisherRequest publisherRequest) {
        var newPublisher = new Publisher(null,
                publisherRequest.name(), new Address(null,
                publisherRequest.primaryAddress().street(),
                publisherRequest.primaryAddress().city(),
                publisherRequest.primaryAddress().state(),
                publisherRequest.primaryAddress().zipCode()));
        var savedPublisher =  publisherRepository.save(newPublisher);
        return new PublisherResponse(
                savedPublisher.getPublisherId(),
                savedPublisher.getName(),
                new AddressResponse(
                        savedPublisher.getPrimaryAddress().getAddressId(),
                        savedPublisher.getPrimaryAddress().getStreet(),
                        savedPublisher.getPrimaryAddress().getCity(),
                        savedPublisher.getPrimaryAddress().getState(),
                        savedPublisher.getPrimaryAddress().getZipCode()
                )
        );
    }

    @Override
    public Publisher getPublisherId(Integer publisherId) throws PublisherNotFoundException {
        return publisherRepository.findById(publisherId)
                .orElseThrow(() -> new PublisherNotFoundException(String.format("Error: Publisher with Id, %d, is not found",
                        publisherId)));
    }

    @Override
    public Publisher updatePublisher(Integer publisherId, Publisher editedPublisher) {
        var publisher = publisherRepository.findById(publisherId).orElse(null);
        if(publisher != null ) {
            publisher.setName(editedPublisher.getName());
            if(publisher.getPrimaryAddress()!=null) {
                var address = publisher.getPrimaryAddress();
                address.setStreet(editedPublisher.getPrimaryAddress().getStreet());
                address.setCity(editedPublisher.getPrimaryAddress().getCity());
                address.setState(editedPublisher.getPrimaryAddress().getState());
                address.setZipCode(editedPublisher.getPrimaryAddress().getZipCode());
            } else {
                var newAddress = new Address();
                newAddress.setStreet(editedPublisher.getPrimaryAddress().getStreet());
                newAddress.setCity(editedPublisher.getPrimaryAddress().getCity());
                newAddress.setState(editedPublisher.getPrimaryAddress().getState());
                newAddress.setZipCode(editedPublisher.getPrimaryAddress().getZipCode());
                newAddress.setPublisher(publisher);
                publisher.setPrimaryAddress(newAddress);
            }
            return publisherRepository.save(publisher);
        } else {
            return null;
        }
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }

    @Override
    public void deletePublisherAddressById(Integer publisherId) {
        var publisher = publisherRepository.findById(publisherId).orElse(null);
        if(publisher != null) {
            var address = publisher.getPrimaryAddress();
            if(address != null) {
//                addressRepository.deleteById(address.getAddressId());
//                publisher.setPrimaryAddress(null);
//                publisherRepository.save(publisher);

                publisher.setPrimaryAddress(null);
                publisherRepository.save(publisher);
                addressRepository.deleteById(address.getAddressId());
            }
        }
    }

    @Override
    public List<Publisher> getPublisherByNameStart(String nameStart) {
        return publisherRepository.findPublisherByNameIsStartingWith(nameStart);
    }

    @Override
    public List<Publisher> searchPublisher(String searchString) {
        return publisherRepository.findPublishersByNameContainingOrPrimaryAddress_StreetContainingOrPrimaryAddress_CityContainingOrPrimaryAddress_StateContaining(
                searchString, searchString, searchString, searchString
        );
    }
}
