package miu.edu.practice.service;

import miu.edu.practice.dto.product.ProductResponse;
import miu.edu.practice.dto.product.ProductResponse3;
import miu.edu.practice.model.Product;

import java.util.List;

public interface ProductService {

    public Product updateProductByProductNo(Integer proNo);

    public List<ProductResponse3> findAllProductSupplier();


}
