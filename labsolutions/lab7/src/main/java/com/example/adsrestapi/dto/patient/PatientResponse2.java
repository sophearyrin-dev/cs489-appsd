package com.example.adsrestapi.dto.patient;

import java.time.LocalDate;

public record PatientResponse2 (
    Integer patientId,

    String fistName,

    String lastName,

    String phoneNumber,

    String email,

    LocalDate dob){

}
