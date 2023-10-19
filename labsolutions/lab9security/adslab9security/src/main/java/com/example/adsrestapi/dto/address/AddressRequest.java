package com.example.adsrestapi.dto.address;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        String street,
        String city,
        String state,
        @NotBlank(message = "ZipCode is required and cannot be null or empty string or blank spaces")
        String zipCode) {
}
