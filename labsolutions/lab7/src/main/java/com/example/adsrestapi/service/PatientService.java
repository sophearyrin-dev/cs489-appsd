package com.example.adsrestapi.service;

import com.example.adsrestapi.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient addNewPatient(Patient newPatient);




}
