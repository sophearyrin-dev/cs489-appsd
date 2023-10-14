package miu.edu.myelibray.elibrayapp;

import miu.edu.myelibray.elibrayapp.model.Address;
import miu.edu.myelibray.elibrayapp.model.Publisher;
import miu.edu.myelibray.elibrayapp.repository.AddressRepository;
import miu.edu.myelibray.elibrayapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ElibrayappApplication implements CommandLineRunner {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public static void main(String[] args) {
        SpringApplication.run(ElibrayappApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        getAllAddress();
//        insertPublisher();

    }

    public  void getAllAddress(){
        List<Address> addresses = addressRepository.findAll();
        System.out.println(addresses);
    }

//    public void insertPublisher(){
//        Address address1 = new Address("89st","IL", "CA","76543");
//        addressRepository.save(address1);
//        Publisher publisher1 = new Publisher("A", address1);
//        publisherRepository.save(publisher1);
//
//    }

}
