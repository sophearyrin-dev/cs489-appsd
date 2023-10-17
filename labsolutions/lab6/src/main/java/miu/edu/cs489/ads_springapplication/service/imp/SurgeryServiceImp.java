package miu.edu.cs489.ads_springapplication.service.imp;

import miu.edu.cs489.ads_springapplication.model.Surgery;
import miu.edu.cs489.ads_springapplication.repository.SurgeryRepository;
import miu.edu.cs489.ads_springapplication.service.SurgeryService;
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
