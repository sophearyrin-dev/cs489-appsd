package miu.edu.cs489.ads_springapplication.repository;

import miu.edu.cs489.ads_springapplication.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
