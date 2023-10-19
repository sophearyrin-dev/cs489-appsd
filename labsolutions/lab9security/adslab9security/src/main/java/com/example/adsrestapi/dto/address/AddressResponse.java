package com.example.adsrestapi.dto.address;

public record AddressResponse (
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode){
}
