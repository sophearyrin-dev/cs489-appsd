package miu.edu.practice.service.imp;

import miu.edu.practice.dto.product.ProductResponse;
import miu.edu.practice.dto.product.ProductResponse3;
import miu.edu.practice.dto.supplier.SupplierResponse;
import miu.edu.practice.dto.supplier.SupplierResponseWithoutProduct;
import miu.edu.practice.model.Product;
import miu.edu.practice.repository.ProductRepository;
import miu.edu.practice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product updateProductByProductNo(Integer proNo) {

        Optional<Product> product = productRepository.findById(proNo);


        return null;
    }

    @Override
    public List<ProductResponse3> findAllProductSupplier() {
        return productRepository.findAll().stream().map(
                product -> new ProductResponse3(
                        product.getProductId(),
                        product.getName(),
                        product.getDateSupplied(),
                        product.getQuantity(),
                        product.getUnitPrice(),
                        new SupplierResponseWithoutProduct(
                                product.getSupplier().getSupplierId(),
                                product.getSupplier().getName(),
                                product.getSupplier().getContactPhoneNumber()
                        )
                )
        ).collect(Collectors.toList());
    }
}
