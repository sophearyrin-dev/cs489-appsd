package cs489.srmwebapi.repository;

import cs489.srmwebapi.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ProductRepository extends ListCrudRepository<Product, Long> {

    Optional<Product> findProductByProductNo(Long productNo);

    @Query(value = "select p from Product p where p.productNo = :productNo")
    Optional<Product> getProductUsingProductNumber(Long productNo);

    @Query(value = "select * from `cs489-srmwebapi-db`.products p where p.product_no = :productNo", nativeQuery = true)
    Optional<Product> getProductUsingProductNumber2(Long productNo);
}
