package miu.edu.cs489.ads_springapplication.repository;

import miu.edu.cs489.ads_springapplication.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery,Integer> {
}
