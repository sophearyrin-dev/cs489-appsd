package miu.edu.practice.repository;

import miu.edu.practice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product p where p.productNo = :proNo", nativeQuery = true)
    Optional<Product> findProductByProNo(Integer proNo);
}
