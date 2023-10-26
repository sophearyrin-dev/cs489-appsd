package com.example.adsrestapi.controller;

import com.example.adsrestapi.dto.address.AddressResponse;
import com.example.adsrestapi.dto.patient.PatientResponse;
import com.example.adsrestapi.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PatientControllerTest {

    @InjectMocks
    private PatientController patientController;

    @Mock
    private PatientService patientService;


    @Test
    public void testGetAllPatientList() {
        // Define test data
        List<PatientResponse> patients = createSamplePatientResponses();

        // Mock the behavior of the patientService
        Mockito.when(patientService.getAllPatients()).thenReturn(patients);

        // Call the controller method and capture the response entity
        ResponseEntity<List<PatientResponse>> responseEntity = patientController.findAllPatientIncludeAddress();

        // Verify the HTTP status code is HttpStatus.OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verify that the response body matches the expected patient list
        assertEquals(patients, responseEntity.getBody());
    }

    private List<PatientResponse> createSamplePatientResponses() {
        // Create and return a list of sample PatientResponse objects
        // Populate this list with test data
        List<PatientResponse> samplePatients = new ArrayList<>();

        // Sample Patient 1
        AddressResponse address1 = new AddressResponse(1, "123 Main St", "City1", "State1", "12345");
        PatientResponse patient1 = new PatientResponse(1, "John", "Doe", "123-456-7890", "john.doe@example.com", LocalDate.of(1990, 5, 15), address1);
        samplePatients.add(patient1);

        // Sample Patient 2
        AddressResponse address2 = new AddressResponse(2, "456 Elm St", "City2", "State2", "54321");
        PatientResponse patient2 = new PatientResponse(2, "Jane", "Smith", "987-654-3210", "jane.smith@example.com", LocalDate.of(1985, 8, 22), address2);
        samplePatients.add(patient2);

        return samplePatients;
    }

}