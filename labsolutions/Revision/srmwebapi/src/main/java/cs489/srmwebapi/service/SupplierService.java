package cs489.srmwebapi.service;

import cs489.srmwebapi.model.Supplier;
import cs489.srmwebapi.repository.SupplierRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliersSorted() {
        return supplierRepository.findAll(Sort.by("name"));
    }

    public List<Supplier> getStarSuppliers() {
        return supplierRepository.findAll(Sort.by("name"))
                .stream()
                .filter(Supplier::isStarSupplier)
                .toList();
    }
}
