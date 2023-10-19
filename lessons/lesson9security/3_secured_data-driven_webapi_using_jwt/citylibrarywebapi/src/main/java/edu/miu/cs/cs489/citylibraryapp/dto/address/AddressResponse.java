package edu.miu.cs.cs489.citylibraryapp.dto.address;

public record AddressResponse(
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode
    ) {
}
