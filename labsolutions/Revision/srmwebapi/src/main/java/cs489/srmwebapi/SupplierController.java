package cs489.srmwebapi;

import cs489.srmwebapi.model.Supplier;
import cs489.srmwebapi.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/srmweb/api/supplier"})
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<Supplier>> listSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliersSorted());
    }

    @GetMapping(value = {"/starsupplier/list"})
    public ResponseEntity<List<Supplier>> listStarSuppliers() {
        return ResponseEntity.ok(supplierService.getStarSuppliers());
    }
}
