package edu.miu.cs.cs489.lesson11.prodmgmtapp;

import edu.miu.cs.cs489.lesson11.prodmgmtapp.dao.ProductDAO;
import edu.miu.cs.cs489.lesson11.prodmgmtapp.model.Product;

public class ProdMgmtApp {

    public static void main(String[] args) {
        System.out.println("Hello, JUnit5 and Hamcrest Demo - Starting ProductMgmtApp...");
    }

    public Product findProductById(Long productId) {
        var dao = new ProductDAO();
        var products = dao.getProducts();
        return products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst().orElse(null);
    }

}
