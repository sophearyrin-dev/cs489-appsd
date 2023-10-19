package com.example.adsrestapi.repository;

import com.example.adsrestapi.dto.patient.PatientResponse;
import com.example.adsrestapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
//
//    List<PatientResponse> findPublishersByNameContainingOrPrimaryAddress_StreetContainingOrPrimaryAddress_CityContainingOrPrimaryAddress_StateContaining(
//            String name, String street, String city, String state
//    );

    List<Patient> findPatientsByFistNameContainingOrLastNameContainingOrPhoneNumberContainingOrEmailOrAddress_StreetOrAddress_CityOrAddress_StateOrAddress_ZipCode(
            String firstName, String lastName, String phoneNumber, String email,
            String street, String city, String state, String zipCode
    );

//    List<PatientResponse> findPatientsByFistNameContaining(String firstName);

}
