package com.example.demo.controller;

import com.example.demo.controller.service.MainService;
import com.example.demo.model.AddMenuItemForm;
import com.example.demo.model.Department;
import com.example.demo.model.Lector;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.LectorRepository;
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
    @Autowired
    private LectorRepository lectorRepository;
    @Autowired
    private MainService mainService;

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

        return "redirect:view/" + department.getId();
    }

    @GetMapping
    @RequestMapping("/view/{departmentId}")
    public String add(@PathVariable String departmentId, Model model){

        Department department = this.departmentRepository.findById(departmentId).get();


        model.addAttribute("title", department.getDepartmentName());
        model.addAttribute("lectors", department.getLectors());
        model.addAttribute("departmentId", department.getId());
        return "departments/view";
    }
//
//    

    @RequestMapping(value = "/view/{departmentId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String departmentId, Model model){

        this.departmentRepository.deleteById(departmentId);
        return "redirect:/departments";
    }

    @GetMapping
    @RequestMapping("/statistics/{departmentId}")
    public String statistic(@PathVariable String departmentId, Model model){

        Department department = this.departmentRepository.findById(departmentId).get();

        int assistants = this.lectorRepository.findLectorsByDegreeAndDepartments(Lector.Degree.ASSISTANT, department).size();
        int associateProfessors = this.lectorRepository.findLectorsByDegreeAndDepartments(Lector.Degree.ASSOSIATE_PROFESSOR, department).size();
        int professors = this.lectorRepository.findLectorsByDegreeAndDepartments(Lector.Degree.PROFESSOR, department).size() ;
        double avgSalary = mainService.averageSalary(department);

        model.addAttribute("title", "Statistic of " + department.getDepartmentName());
        model.addAttribute("lectors", department.getLectors());

        model.addAttribute("amountOfAssistants", assistants);
        model.addAttribute("amountOfAssociateProfessors", associateProfessors);
        model.addAttribute("amountOfProfessors", professors);
        model.addAttribute("avgSalary", avgSalary);

        model.addAttribute("departmentId", department.getId());
        return "departments/statistics";
    }

    @GetMapping
    @RequestMapping("/add-item/{departmentId}")
    public String addItem(@PathVariable String departmentId, Model model){

        Department department = this.departmentRepository.findById(departmentId).get();

        AddMenuItemForm form = new AddMenuItemForm(this.lectorRepository.findAll(), department);
        model.addAttribute("title", "Add item to department " + department.getDepartmentName());
//        System.out.println(form);
        model.addAttribute("form", form);
        return "departments/add-item";
    }

    @PostMapping
    @RequestMapping("/add-item")
    public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm form, Errors errors){

//        System.out.println(form);

        if (errors.hasErrors()){
            model.addAttribute("form", form);
            return "departments/add-item";
        }

        Lector lector = this.lectorRepository.findById(form.getLectorId()).get();
        Department department =this.departmentRepository.findById(form.getDepartmentId()).get();
        department.addItem(lector);
        System.out.println(department.getLectors());
        this.departmentRepository.save(department);
        return "redirect:/departments/view/" + department.getId();
    }








//    @GetMapping
//    @RequestMapping("/{id}")
//    public String add(@PathVariable String id, Model model){
//
//        Department department = this.departmentRepository.findById(id).get();
//        model.addAttribute("name", department.getDepartmentName());
//        model.addAttribute("lectors", department.getLectors());
//        model.addAttribute("depId", department.getId());
//        return "departments/view";
//    }
//
//    @GetMapping
//    @RequestMapping("/{id}/addLector")
//    public String addLectorToDepartment(@PathVariable String id, Model model) {
//
//        Department department = this.departmentRepository.findById(id).get();
//        AddMenuItemForm form = new AddMenuItemForm(this.lectorRepository.findAll(), department);
////
//        model.addAttribute("title", "Add item to Department: " + department.getDepartmentName());
////        model.addAttribute("depId", department.getId());
//        model.addAttribute("form", form);
////        model.addAttribute("lectors", this.lectorRepository.findAll());
//        return "departments/addLector";
//    }

//    @PostMapping
//    @RequestMapping("/new")
//    public String currentDepartments
}
