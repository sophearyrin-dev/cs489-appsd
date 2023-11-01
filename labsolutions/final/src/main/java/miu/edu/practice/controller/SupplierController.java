package miu.edu.practice.controller;


import miu.edu.practice.dto.supplier.SupplierResponse;
import miu.edu.practice.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finalpractice/api/v1/supplier/")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<SupplierResponse>> findAllSuppliers(){
        return new ResponseEntity<>(supplierService.findAllSuppliers(), HttpStatus.OK);
    }

    @GetMapping("/starlist")
    public ResponseEntity<List<SupplierResponse>> findAllStarSuppliers(){
        return new ResponseEntity<>(supplierService.starList(), HttpStatus.OK);
    }
}
