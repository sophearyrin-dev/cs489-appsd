package com.example.adsrestapi.repository;

import com.example.adsrestapi.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery,Integer> {
}
