package miu.edu.camsys.camsys614133.onetomany.repository;

import miu.edu.camsys.camsys614133.onetomany.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial,Integer> {
}
