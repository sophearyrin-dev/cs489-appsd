package com.example.adsrestapi.service.imp;

import com.example.adsrestapi.dto.address.AddressResponse;
import com.example.adsrestapi.dto.patient.PatientResponse;
import com.example.adsrestapi.exception.PatientNotFoundException;
import com.example.adsrestapi.model.Address;
import com.example.adsrestapi.model.Patient;
import com.example.adsrestapi.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AssertionErrors;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PatientServiceImpTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImp patientServiceImp;

    @Test
    public void testGetPatientByIdFound() {
        // Define test data
        int patientId = 1;

        // Create a patient with required data and a valid primaryAddress
        Patient patient = new Patient();
        patient.setPatientId(patientId);
        patient.setFistName("John");
        patient.setLastName("Doe");
        patient.setPhoneNumber("123-456-7890");
        patient.setEmail("john.doe@example.com");
        // Set other patient properties as needed

        Address primaryAddress = new Address();
        primaryAddress.setAddressId(1);
        primaryAddress.setStreet("123 Main St");
        primaryAddress.setCity("City");
        primaryAddress.setState("State");
        primaryAddress.setZipCode("12345");

        patient.setPrimaryAddress(primaryAddress);

        // Mock the behavior of the patientRepository for a found patient
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

        // Call the method to be tested
        PatientResponse patientResponse = null;
        try {
            patientResponse = patientServiceImp.getPatientById(patientId);
        } catch (PatientNotFoundException e) {
            e.printStackTrace();
        }

        // Define expected results
        PatientResponse expectedResponse = new PatientResponse(
                patient.getPatientId(),
                patient.getFistName(),
                patient.getLastName(),
                patient.getPhoneNumber(),
                patient.getEmail(),
                patient.getDob(),
                new AddressResponse(
                        primaryAddress.getAddressId(),
                        primaryAddress.getStreet(),
                        primaryAddress.getCity(),
                        primaryAddress.getState(),
                        primaryAddress.getZipCode()
                )
        );

        // Assert that the method's response matches the expected result
        assertEquals(expectedResponse, patientResponse);
    }


    @Test
    public void testGetPatientByIdNotFound() {
        // Define test data
        int patientId = 2; // Id for a patient that does not exist in the repository

        // Mock the behavior of the patientRepository for a not found patient
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        // Call the method to be tested
        try {
            PatientResponse patientResponse = patientServiceImp.getPatientById(patientId);

            // If the patient is not found, an exception should be thrown, so this assertion should not be reached.
            AssertionErrors.assertNull("Expected PatientNotFoundException to be thrown, but got a result", patientResponse);
        } catch (PatientNotFoundException e) {
            // Verify that the exception message contains the expected error message
            assertEquals("Error: Patient with Id, 2, is not found", e.getMessage());
        }
    }
}