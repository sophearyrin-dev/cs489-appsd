package com.example.tutorialtag.repository;

import com.example.tutorialtag.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
}
