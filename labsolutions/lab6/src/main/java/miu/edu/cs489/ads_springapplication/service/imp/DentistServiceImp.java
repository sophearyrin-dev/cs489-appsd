package miu.edu.cs489.ads_springapplication.service.imp;

import miu.edu.cs489.ads_springapplication.model.Dentist;
import miu.edu.cs489.ads_springapplication.repository.DentistRepository;
import miu.edu.cs489.ads_springapplication.service.DentistService;
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
