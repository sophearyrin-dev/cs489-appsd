package miu.edu.practice.dto.product;

import miu.edu.practice.dto.supplier.SupplierResponse;
import miu.edu.practice.dto.supplier.SupplierResponseWithoutProduct;

import java.time.LocalDate;

public record ProductResponse(
        Integer productId,

        String name,

        LocalDate dateSupplied,

        int quantity,

        double unitPrice
) {
}
