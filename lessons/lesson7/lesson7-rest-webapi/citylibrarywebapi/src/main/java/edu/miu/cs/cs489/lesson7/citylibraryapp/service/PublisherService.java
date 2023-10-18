package edu.miu.cs.cs489.lesson7.citylibraryapp.service;

import edu.miu.cs.cs489.lesson7.citylibraryapp.dto.publisher.PublisherResponse;
import edu.miu.cs.cs489.lesson7.citylibraryapp.exception.PublisherNotFoundException;
import edu.miu.cs.cs489.lesson7.citylibraryapp.model.Publisher;

import java.util.List;

public interface PublisherService {

    List<PublisherResponse> getAllPublishers();

    Publisher addNewPublisher(Publisher newPublisher);

    Publisher getPublisherId(Integer publisherId) throws PublisherNotFoundException;

    Publisher updatePublisher(Integer publisherId, Publisher editedPublished);

    void deletePublisherById(Integer publisherId);

    void deletePublisherAddressById(Integer publisherId);

    List<Publisher> getPublisherByNameStart(String nameStart);

    List<Publisher> searchPublisher(String searchString);

}
