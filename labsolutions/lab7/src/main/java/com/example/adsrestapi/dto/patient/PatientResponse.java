package com.example.adsrestapi.dto.patient;


import com.example.adsrestapi.dto.address.AddressResponse;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PatientResponse(

        Integer patientId,

        String fistName,

        String lastName,

        String phoneNumber,

        String email,

        LocalDate dob,

        AddressResponse primaryAddress
) {

}
