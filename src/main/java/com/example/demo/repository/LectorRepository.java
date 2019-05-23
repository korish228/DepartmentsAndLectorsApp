package com.example.demo.repository;

import com.example.demo.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends JpaRepository<Lector, String> {
    Lector findLectorById(String id);
}
