package edu.miu.cs.cs489.lesson7.citylibraryapp.repository;

import edu.miu.cs.cs489.lesson7.citylibraryapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    @Query(value = "select p from Publisher p")
    public List<Publisher> getMyCustomListOfPublisher();

    @Query(value = "select p from Publisher p where p.name = :name")
    public Optional<Publisher> getMyCustomPublisherByName(String name);

    @Query(value = "SELECT * FROM `cs489-apsd-citylibrary-db2`.publishers p where p.name like 'Ap%'", nativeQuery = true)
    public Optional<Publisher> getMyNativeCustomPublisherByName(String name);

    // Using Query methods
    public List<Publisher> findPublisherByNameIsStartingWith(String strNameStart);
    public List<Publisher> findPublishersByNameContainingOrPrimaryAddress_StreetContainingOrPrimaryAddress_CityContainingOrPrimaryAddress_StateContaining(
            String name, String street, String city, String state
    );

//    SELECT p.*, a.* FROM `cs489-apsd-citylibrary-db2`.publishers p
//    inner join `cs489-apsd-citylibrary-db2`.addresses a
//    on p.address_id = a.address_id
//    where p.name like '%CA%'
//    OR a.street like '%CA%'
//    OR a.city like '%CA%'
//    OR a.state like '%CA%'
}
