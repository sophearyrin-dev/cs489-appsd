package miu.edu.myelibray.elibrayapp.service.imp;

import miu.edu.myelibray.elibrayapp.model.Publisher;
import miu.edu.myelibray.elibrayapp.repository.PublisherRepository;
import miu.edu.myelibray.elibrayapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServieImp implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher addNewPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
    }
}
