package miu.edu.practice.dto.supplier;

import miu.edu.practice.dto.product.ProductResponse;

import java.util.List;

public record SupplierResponse(

        Integer supplierId,

        String name,

        String contactPhoneNumber,

        List<ProductResponse> products
) {
}
