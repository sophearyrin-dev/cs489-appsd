package edu.miu.cs.cs489.lesson6.citylibraryapp;

import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Address;
import edu.miu.cs.cs489.lesson6.citylibraryapp.model.Publisher;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.AddressService;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitylibrarycliappApplication implements CommandLineRunner {

    private final PublisherService publisherService;
    private final AddressService addressService;

    public CitylibrarycliappApplication(PublisherService publisherService,
                                        AddressService addressService) {
        this.publisherService = publisherService;
        this.addressService = addressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CitylibrarycliappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Data Persistence using Spring Data JPA");
        // Create new Publisher with existing Address
//        System.out.println("Creating new Publisher with existing Address");
//        var saveMcGraw = addNewPublisher("McGraw-Hill");
//        System.out.println("McGraw-Hill added");
//        System.out.println(saveMcGraw);
//        System.out.println("Creating new Publisher with new Address");
//        var apressAddr = new Address(null, "20 South Court", "Los Angeles", "CA", "90210-0002");
//        var savedApress = addNewPublisherAndAddress("Apress", apressAddr);
//        System.out.println(savedApress);
//        printAllPublishers();
        var publisherId =  3;
//        var publisherFound = getPublisherById(publisherId);
//        if(publisherFound != null) {
//            System.out.printf("Publisher with id: %d, found\n %s", publisherId, publisherFound);
//        } else {
//            System.out.printf("Error: Publisher with id: %d, is not found\n", publisherId);
//        }
//        var publisherUpdated = updatePublisherById(publisherId);
//        if(publisherUpdated != null) {
//            System.out.printf("Publisher with id: %d, updated\n %s", publisherId, publisherUpdated);
//        } else {
//            System.out.printf("Error: Publisher with id: %d, is not found\n", publisherId);
//        }
        // Delete publisher by id
//        publisherService.deletePubisherById(4);

        System.out.println(publisherService.getPublisherByNameStart("Ap"));
    }

    private Publisher addNewPublisher(String name) {
        // Create the address
        var mcGrawAddr = addNewAddress("1000 N 4th Street", "Fairfield", "IA", "52556-0001" );
        var mcGrawHill = new Publisher(null, name, mcGrawAddr);

        return publisherService.addNewPublisher(mcGrawHill);
    }

    private Publisher addNewPublisherAndAddress(String name, Address address) {
        var apress = new Publisher(null, name, address);
        return publisherService.addNewPublisher(apress);
    }

    private Address addNewAddress(String street, String city, String state, String zipCode) {
        var mcGrawAddr = new Address(null, street, city, state, zipCode, null);
        return addressService.addNewAddress(mcGrawAddr);
    }

    private Publisher getPublisherById(Integer publisherId) {
        return publisherService.getPublisherId(publisherId);
    }

    private void printAllPublishers() {
        publisherService.getAllPublishers()
                .forEach(System.out::println);
    }

    private Publisher updatePublisherById(Integer publisherId) {
        var publisherFound = getPublisherById(publisherId);
        if(publisherFound != null) {
            var address = new Address(null, "12 14th Street", "New York", "NY", "10927");
            publisherFound.setPrimaryAddress(address);
            return publisherService.updatePublisher(publisherFound);
        } else {
            return null;
        }
    }
}
