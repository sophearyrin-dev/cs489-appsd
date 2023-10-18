package com.example.adsrestapi.service.imp;

import com.example.adsrestapi.model.Patient;
import com.example.adsrestapi.repository.PatientRepository;
import com.example.adsrestapi.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImp implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient addNewPatient(Patient newPatient) {
        return patientRepository.save(newPatient);
    }
}
