package com.example.tutorialtag.repository;

import com.example.tutorialtag.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Integer> {
}
