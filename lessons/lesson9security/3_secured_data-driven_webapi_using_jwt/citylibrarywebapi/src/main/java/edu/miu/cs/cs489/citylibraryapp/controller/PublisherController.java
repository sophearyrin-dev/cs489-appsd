package edu.miu.cs.cs489.citylibraryapp.controller;

import edu.miu.cs.cs489.citylibraryapp.dto.publisher.PublisherRequest;
import edu.miu.cs.cs489.citylibraryapp.dto.publisher.PublisherResponse;
import edu.miu.cs.cs489.citylibraryapp.exception.PublisherNotFoundException;
import edu.miu.cs.cs489.citylibraryapp.model.Publisher;
import edu.miu.cs.cs489.citylibraryapp.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/citylibrary/api/v1/publisher")
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<PublisherResponse>> listPublishers() {
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }

    // Send publisherId as Query Parameter
//    @GetMapping(value = "/citylibrary/api/v1/publisher/?publisherId={publisherId}")
//    public ResponseEntity<Publisher> getPublisherById(@RequestParam Integer publisherId) {
//
//    }

    // Send publisherId as PathVariable
    @GetMapping(value = "/{publisherId}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer publisherId) throws PublisherNotFoundException {
        return ResponseEntity.ok(publisherService.getPublisherId(publisherId));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<PublisherResponse> registerNewPublisher(@RequestBody @Valid PublisherRequest publisherRequest) {
        return new ResponseEntity<>(publisherService.addNewPublisher(publisherRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{publisherId}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Integer publisherId,
                                                     @RequestBody Publisher editedPublisher) {
        return new ResponseEntity<>(publisherService.updatePublisher(publisherId, editedPublisher),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{publisherId}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Integer publisherId) {
        publisherService.deletePublisherById(publisherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/address/delete/{publisherId}")
    public ResponseEntity<Void> deletePublisherAddressById(@PathVariable Integer publisherId) {
        publisherService.deletePublisherAddressById(publisherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/search/{searchString}")
    public ResponseEntity<List<Publisher>> searchPublisher(@PathVariable String searchString) {
        return ResponseEntity.ok(publisherService.searchPublisher(searchString));
    }

}
