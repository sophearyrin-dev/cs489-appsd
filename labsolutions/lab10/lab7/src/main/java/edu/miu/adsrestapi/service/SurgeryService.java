package com.example.adsrestapi.service;

import com.example.adsrestapi.model.Surgery;

import java.util.List;

public interface SurgeryService {

    List<Surgery> getAllSurgeries();

    Surgery addNewSurgery(Surgery newSurgery);
}
