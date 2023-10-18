package edu.miu.cs.cs489.lesson6.citylibraryapp.service.impl;

import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Publisher;
import edu.miu.cs.cs489.lesson6.citylibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

//    @Autowired
    private PublisherRepository publisherRepository;

//    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

//    public PublisherServiceImpl() {
//
//    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher addNewPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
    }

    @Override
    public Publisher getPublisherId(Integer publisherId) {
        return publisherRepository.findById(publisherId)
                .orElse(null);
    }

    @Override
    public Publisher updatePublisher(Publisher editedPublished) {
        return publisherRepository.save(editedPublished);
    }

    @Override
    public void deletePubisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }

    @Override
    public List<Publisher> getPublisherByNameStart(String nameStart) {
        return publisherRepository.findPublisherByNameIsStartingWith(nameStart);
    }
}
