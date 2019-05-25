package com.example.demo.controller;

import com.example.demo.controller.service.MainService;
import com.example.demo.model.Lector;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
