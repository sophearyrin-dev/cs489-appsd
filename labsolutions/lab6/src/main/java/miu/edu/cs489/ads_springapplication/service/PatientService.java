package miu.edu.cs489.ads_springapplication.service;

import miu.edu.cs489.ads_springapplication.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient addNewPatient(Patient newPatient);


}
