package edu.miu.cs.cs489.lesson7.citylibraryapp.dto.address;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        @NotBlank(message = "Street is required and cannot be null or empty string or blank spaces") String street,
        @NotBlank(message = "City is required and cannot be null or empty string or blank spaces") String city,
        String state,
        String zipCode
    ) {
}
