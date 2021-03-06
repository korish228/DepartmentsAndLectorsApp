package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Lector;

import java.util.List;

public interface MainService {
    double averageSalary(Department department);
    List<Lector> findByName(String name);
}
