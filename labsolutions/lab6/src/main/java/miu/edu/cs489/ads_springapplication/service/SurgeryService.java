package miu.edu.cs489.ads_springapplication.service;

import miu.edu.cs489.ads_springapplication.model.Surgery;

import java.util.List;

public interface SurgeryService {

    List<Surgery> getAllSurgeries();

    Surgery addNewSurgery(Surgery newSurgery);
}
