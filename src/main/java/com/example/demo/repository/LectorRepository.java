package com.example.demo.repository;

import com.example.demo.model.Department;
import com.example.demo.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, String> {
    Lector findLectorById(String id);


    List<Lector> findLectorsByDegreeAndDepartments(Enum degree, Department department);

    List<Lector> findLectorsByDepartments(Department department);
//
//    List<Lector> findAllByDegree_AssosiateProfessor();
//
//    List<Lector> findAllByDegree_Professor();
}
