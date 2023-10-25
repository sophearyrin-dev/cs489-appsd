package edu.miu.cs.cs489.lesson11.prodmgmtapp.dao;

import edu.miu.cs.cs489.lesson11.prodmgmtapp.model.Product;

import java.util.List;

public class ProductDAO {

    private List<Product> products = null;

    public List<Product> getProducts() {
        if(products == null) {
            products = List.of(
                    new Product(1L, "Banana"),
                    new Product(2L, "Apple")
            );
        }
        return products;
    }
}
