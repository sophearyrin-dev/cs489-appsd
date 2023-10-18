package edu.miu.cs.cs489.lesson7.citylibraryapp.repository;

import edu.miu.cs.cs489.lesson7.citylibraryapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
