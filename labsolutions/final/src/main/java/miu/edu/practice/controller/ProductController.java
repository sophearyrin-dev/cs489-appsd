package miu.edu.practice.controller;

import miu.edu.practice.dto.product.ProductResponse;
import miu.edu.practice.dto.product.ProductResponse3;
import miu.edu.practice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finalpractice/api/v1/product/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponse3>> findAllProductIncludeSupplier(){
        System.out.println(productService.findAllProductSupplier());
        return new ResponseEntity<>(productService.findAllProductSupplier(),
                HttpStatus.OK);
    }
}
