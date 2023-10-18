package com.example.adsrestapi.service;

import com.example.adsrestapi.model.Dentist;

import java.util.List;

public interface DentistService {

    List<Dentist> getAllDentists();

    Dentist addNewDentist(Dentist newDentist);
}
