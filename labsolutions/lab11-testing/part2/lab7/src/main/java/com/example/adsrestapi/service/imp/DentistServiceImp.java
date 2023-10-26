package com.example.adsrestapi.service.imp;

import com.example.adsrestapi.model.Dentist;
import com.example.adsrestapi.repository.DentistRepository;
import com.example.adsrestapi.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImp implements DentistService {

    private DentistRepository dentistRepository;

    public DentistServiceImp(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }


    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist addNewDentist(Dentist newDentist) {
        return dentistRepository.save(newDentist);
    }
}
