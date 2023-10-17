package miu.edu.cs489.ads_springapplication.service.imp;

import miu.edu.cs489.ads_springapplication.model.Patient;
import miu.edu.cs489.ads_springapplication.repository.PatientRepository;
import miu.edu.cs489.ads_springapplication.service.PatientService;
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
