package miu.edu.cs489.ads_springapplication.service;

import miu.edu.cs489.ads_springapplication.model.Dentist;

import java.util.List;

public interface DentistService {

    List<Dentist> getAllDentists();

    Dentist addNewDentist(Dentist newDentist);
}
