package com.example.adsrestapi.service.imp;

import com.example.adsrestapi.dto.address.AddressRequest;
import com.example.adsrestapi.dto.address.AddressResponse;
import com.example.adsrestapi.dto.patient.PatientRequest;
import com.example.adsrestapi.dto.patient.PatientResponse;
import com.example.adsrestapi.exception.PatientNotFoundException;
import com.example.adsrestapi.model.Address;
import com.example.adsrestapi.model.Patient;
import com.example.adsrestapi.repository.PatientRepository;
import com.example.adsrestapi.service.PatientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImp implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll(Sort.by("lastName")).stream()
                .map(p -> new PatientResponse(
                        p.getPatientId(),
                        p.getFistName(),
                        p.getLastName(),
                        p.getPhoneNumber(),
                        p.getEmail(),
                        p.getDob(),
                        new AddressResponse(
                                p.getAddress().getAddressId(),
                                p.getAddress().getStreet(),
                                p.getAddress().getCity(),
                                p.getAddress().getState(),
                                p.getAddress().getZipCode()
                        )
                )).collect(Collectors.toList());
    }

    @Override
    public PatientResponse addNewPatient(PatientRequest patientRequest) {

        var newPatient = new Patient(
                patientRequest.fistName(),
                patientRequest.lastName(),
                patientRequest.phoneNumber(),
                patientRequest.email(),
                patientRequest.dob(), new Address(
                        patientRequest.primaryAddress().street(),
                        patientRequest.primaryAddress().city(),
                        patientRequest.primaryAddress().state(),
                        patientRequest.primaryAddress().zipCode()
        ));

        var savedPatient = patientRepository.save(newPatient);

        PatientResponse patientResponse = new PatientResponse(
                savedPatient.getPatientId(),
                savedPatient.getFistName(),
                savedPatient.getLastName(),
                savedPatient.getPhoneNumber(),
                savedPatient.getEmail(),
                savedPatient.getDob(),
                new AddressResponse(
                        savedPatient.getAddress().getAddressId(),
                        savedPatient.getAddress().getStreet(),
                        savedPatient.getAddress().getCity(),
                        savedPatient.getAddress().getState(),
                        savedPatient.getAddress().getZipCode()
                )
        );
        return patientResponse;
    }

    @Override
    public PatientResponse getPatientById(int patientId) throws PatientNotFoundException {
        var patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(
                        String.format("Error: Patient with Id, %d, is not found", patientId)));

        PatientResponse patientResponse = new PatientResponse(
                patient.getPatientId(),
                patient.getFistName(),
                patient.getLastName(),
                patient.getPhoneNumber(),
                patient.getEmail(),
                patient.getDob(),
                new AddressResponse(
                        patient.getAddress().getAddressId(),
                        patient.getAddress().getStreet(),
                        patient.getAddress().getCity(),
                        patient.getAddress().getState(),
                        patient.getAddress().getZipCode()
                )

        );
        return patientResponse;
    }

    @Override
    public PatientResponse updatePatientById(PatientRequest patientRequest, int patientId)
            throws PatientNotFoundException{

        var patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(
                        String.format("Error: Patient with Id, %d, is not found", patientId)));


        patient.setFistName(patientRequest.fistName());
        patient.setLastName(patientRequest.lastName());
        patient.setPhoneNumber(patientRequest.phoneNumber());
        patient.setEmail(patientRequest.email());
        patient.setDob(patientRequest.dob());

        patient.setAddress(new Address(
                patientRequest.primaryAddress().street(),
                patientRequest.primaryAddress().city(),
                patientRequest.primaryAddress().state(),
                patientRequest.primaryAddress().zipCode()
        ));


        var updatedPatient = patientRepository.save(patient);

        PatientResponse patientResponse = new PatientResponse(
                updatedPatient.getPatientId(),
                updatedPatient.getFistName(),
                updatedPatient.getLastName(),
                updatedPatient.getPhoneNumber(),
                updatedPatient.getEmail(),
                updatedPatient.getDob(),
                new AddressResponse(
                        updatedPatient.getAddress().getAddressId(),
                        updatedPatient.getAddress().getStreet(),
                        updatedPatient.getAddress().getCity(),
                        updatedPatient.getAddress().getState(),
                        updatedPatient.getAddress().getZipCode()
                )
        );

        return patientResponse;
    }

    @Override
    public void deletePatientById(int patientId) throws PatientNotFoundException{
        patientRepository.deleteById(patientId);
    }


}
