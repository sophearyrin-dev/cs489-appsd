package miu.edu.practice.dto.supplier;


public record SupplierResponseWithoutProduct(

        Integer supplierId,

        String name,

        String contactPhoneNumber

) {
}
