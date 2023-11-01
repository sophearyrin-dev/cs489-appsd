package cs489.srmwebapi;

import cs489.srmwebapi.dto.ProductResponse;
import cs489.srmwebapi.model.Product;
import cs489.srmwebapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/srmweb/api/product"})
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping(value = {"/update/{productNo}"})
    public ResponseEntity<Product> updateProduct(@PathVariable Long productNo, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProductByProductNo(productNo, product),
                HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponse>> findAllProductIncludeSupplier(){
        System.out.println(productService.findAllProductIncludeSupplier());
        return new ResponseEntity<>(productService.findAllProductIncludeSupplier(),
                HttpStatus.OK);
    }
}
