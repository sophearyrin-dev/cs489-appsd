package com.example.adsrestapi.dto.address;

import com.example.adsrestapi.dto.patient.PatientResponse;
import com.example.adsrestapi.dto.patient.PatientResponse2;

public record AddressPatientResponse (
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode,
        PatientResponse2 patientResponse
){
}
