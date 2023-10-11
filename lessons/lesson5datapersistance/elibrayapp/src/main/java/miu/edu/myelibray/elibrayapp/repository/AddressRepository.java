package miu.edu.myelibray.elibrayapp.repository;

import miu.edu.myelibray.elibrayapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,String> {
}
