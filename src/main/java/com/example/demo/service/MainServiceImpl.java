package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Lector;
import com.example.demo.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private LectorRepository lectorRepository;

//    for statistic page
    public double averageSalary(Department department){
        List<Lector> lectors = this.lectorRepository.findLectorsByDepartments(department);

        double allSallary =0;

        for (Lector l : lectors) {
            allSallary +=l.getSalary();
        }

        return allSallary / lectors.size();
    }

//    For Searching Lectors (Basic page)
    @Override
    public List<Lector> findByName(String name) {
        return this.lectorRepository.findLectorsByFirstNameLikeOrLastNameLike("%"+ name + "%","%"+ name + "%");
    }

}
