package com.example.demo.controller;

import com.example.demo.model.Lector;
import com.example.demo.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/lectors")
public class LectorController {
    @Autowired
    private LectorRepository lectorRepository;

    @GetMapping
    public String lectors(Model model){
        List<Lector> lectors = lectorRepository.findAll();
        model.addAttribute("title", "Lectors:");
        model.addAttribute("lectors", lectors);
        return "lectors/index";
    }

    @GetMapping("/add")
//    @RequestMapping(value = "/add")
    public String add(Model model){
        model.addAttribute("title", "Add Lector:");
        model.addAttribute("lector", new Lector());
        return "lectors/add";
    }

    @PostMapping("/add")
//    @RequestMapping(value = "/add")
    public String add(Model model, @ModelAttribute @Valid Lector lector, Errors errors){


//        if (errors.hasErrors()){
//            model.addAttribute("title", "Add Lector:");
//            model.addAttribute(errors);
//            return "lectors/add";
//        }

        this.lectorRepository.save(lector);
        return "redirect: index";
    }


//
//    @GetMapping
//    @RequestMapping("/{id}")
//    public String currentLectors(@PathVariable String id, Model model){
//        Lector lector = lectorRepository.findLectorById(id);
//        model.addAttribute("lector", lector);
//        return "lectors/lectors";
//    }

}
