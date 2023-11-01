package miu.edu.practice.service.imp;

import miu.edu.practice.dto.product.ProductResponse;
import miu.edu.practice.dto.supplier.SupplierResponse;
import miu.edu.practice.repository.SupplierRepository;
import miu.edu.practice.service.SupplierService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImp implements SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierServiceImp(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierResponse> findAllSuppliers() {
        return supplierRepository.findAll(Sort.by("name")).stream().map(
                supplier -> new SupplierResponse(
                        supplier.getSupplierId(),
                        supplier.getName(),
                        supplier.getContactPhoneNumber(),
                        supplier.getProducts().stream()
                                .map(product -> new ProductResponse(
                                        product.getProductId(),
                                    product.getName(),
                                    product.getDateSupplied(),
                                    product.getQuantity(),
                                    product.getUnitPrice()
                        )).collect(Collectors.toList())
                     )).collect(Collectors.toList());
    }

    public List<SupplierResponse> starList(){
        return supplierRepository.findAll(Sort.by("name")).stream()
                .filter(s -> s.isStart())
                .map(
                        supplier -> new SupplierResponse(
                                supplier.getSupplierId(),
                                supplier.getName(),
                                supplier.getContactPhoneNumber(),
                                supplier.getProducts().stream()
                                        .map(product -> new ProductResponse(
                                                product.getProductId(),
                                                product.getName(),
                                                product.getDateSupplied(),
                                                product.getQuantity(),
                                                product.getUnitPrice()
                                        )).collect(Collectors.toList())
                        )).collect(Collectors.toList());
    }
}
