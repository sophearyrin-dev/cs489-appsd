package cs489.srmwebapi.dto;


import cs489.srmwebapi.model.Supplier;

import java.time.LocalDate;

public record ProductResponse(

        Long productId,

        Long productNo,

        String name,

        LocalDate dateSupplied,

        Integer quantityInStock,

        Double unitPrice,

        Supplier supplier
) {
}
