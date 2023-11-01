package miu.edu.practice.service;

import miu.edu.practice.dto.supplier.SupplierResponse;
import miu.edu.practice.model.Supplier;

import java.util.List;

public interface SupplierService {

    List<SupplierResponse> findAllSuppliers();

    List<SupplierResponse> starList();
}
