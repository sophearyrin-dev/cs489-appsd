package edu.miu.cs.cs489.lesson7.citylibraryapp.service.impl;

import edu.miu.cs.cs489.lesson7.citylibraryapp.dto.address.AddressResponse;
import edu.miu.cs.cs489.lesson7.citylibraryapp.dto.publisher.PublisherResponse;
import edu.miu.cs.cs489.lesson7.citylibraryapp.exception.PublisherNotFoundException;
import edu.miu.cs.cs489.lesson7.citylibraryapp.model.Publisher;
import edu.miu.cs.cs489.lesson7.citylibraryapp.repository.AddressRepository;
import edu.miu.cs.cs489.lesson7.citylibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs489.lesson7.citylibraryapp.service.PublisherService;
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
                        new AddressResponse(
                                p.getPrimaryAddress().getAddressId(),
                                p.getPrimaryAddress().getStreet(),
                                p.getPrimaryAddress().getCity(),
                                p.getPrimaryAddress().getState(),
                                p.getPrimaryAddress().getZipCode()
                        )
                )).toList();
    }

    @Override
    public Publisher addNewPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
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
            var address = publisher.getPrimaryAddress();
            address.setStreet(editedPublisher.getPrimaryAddress().getStreet());
            address.setCity(editedPublisher.getPrimaryAddress().getCity());
            address.setState(editedPublisher.getPrimaryAddress().getState());
            address.setZipCode(editedPublisher.getPrimaryAddress().getZipCode());
            return publisherRepository.save(publisher);
        } else {
            return publisher;
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
                addressRepository.deleteById(address.getAddressId());
                publisher.setPrimaryAddress(null);
                publisherRepository.save(publisher);
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
