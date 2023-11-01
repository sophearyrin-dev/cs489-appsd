package miu.edu.practice.dto.product;

import miu.edu.practice.dto.supplier.SupplierResponseWithoutProduct;

import java.time.LocalDate;

public record ProductResponse3(

        Integer productId,

        String name,

        LocalDate dateSupplied,

        int quantity,

        double unitPrice,

        SupplierResponseWithoutProduct supplier
) {
}
