package com.example.adsrestapi.dto.patient;


import com.example.adsrestapi.dto.address.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record PatientRequest(

        String fistName,

        String lastName,

        String phoneNumber,

        @NotBlank(message = "Patient email is required and cannot be null or empty string or blank spaces")
        String email,

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate dob,

        @Valid AddressRequest primaryAddress
) {
}
