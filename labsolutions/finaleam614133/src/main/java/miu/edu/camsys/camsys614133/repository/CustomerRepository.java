package miu.edu.camsys.camsys614133.repository;

import miu.edu.camsys.camsys614133.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
