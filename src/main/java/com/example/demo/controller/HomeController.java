package com.example.demo.controller;

import com.example.demo.service.MainService;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private LectorRepository lectorRepository;
    @Autowired
    private MainService mainService;


//    Opens(Main) main page /lectors
    @GetMapping
    public String home(){
        return "redirect:lectors";
    }


}
