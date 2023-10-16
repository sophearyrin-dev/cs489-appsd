package miu.edu.myelibray.elibrayapp.service;

import miu.edu.myelibray.elibrayapp.model.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    Publisher addNewPublisher(Publisher newPublisher);

}
