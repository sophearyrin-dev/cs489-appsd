package edu.miu.cs.cs489.lesson6.citylibraryapp.service;

import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getAllPublishers();
    Publisher addNewPublisher(Publisher newPublisher);

    Publisher getPublisherId(Integer publisherId);

    Publisher updatePublisher(Publisher editedPublished);

    void deletePubisherById(Integer publisherId);

    List<Publisher> getPublisherByNameStart(String nameStart);

}
