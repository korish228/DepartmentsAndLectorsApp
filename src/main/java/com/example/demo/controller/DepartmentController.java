package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public String departments(Model model){
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments", departments);
        return "departments/index";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("title", "Add new Department");
        model.addAttribute("department",new Department());
        return "departments/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model , @ModelAttribute @Valid Department department , Errors errors){
        System.out.println(department);
        if (errors.hasErrors()){
            model.addAttribute("title", "Add new Department");
            return "departments/add";
        }

        this.departmentRepository.save(department);

        return "redirect: index";
    }
//
//    @GetMapping
//    @RequestMapping("/view/{id}")
//    public String add(@PathVariable String id, Model model){
//        Department department = this.departmentRepository.findById(id).get();
//        model.addAttribute("name", department.getDepartmentName());
//        model.addAttribute("lectors", department.getLectors());
//        model.addAttribute("depId", department.getId());
//        return "departments/view";
//    }


//    @PostMapping
//    @RequestMapping("/new")
//    public String currentDepartments
}
