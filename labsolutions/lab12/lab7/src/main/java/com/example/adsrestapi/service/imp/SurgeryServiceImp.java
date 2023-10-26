package com.example.adsrestapi.service.imp;

import com.example.adsrestapi.model.Surgery;
import com.example.adsrestapi.repository.SurgeryRepository;
import com.example.adsrestapi.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImp implements SurgeryService {

    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImp(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }


    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery addNewSurgery(Surgery newSurgery) {
        return surgeryRepository.save(newSurgery);
    }
}
