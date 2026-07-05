package com.information.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.information.demo.entity.Student;
import com.information.demo.infoservice.Serviceinfo;

import org.springframework.ui.Model;
import jakarta.validation.Valid;
@Controller
public class Infocontroller {

    @Autowired
    private Serviceinfo service;

    @GetMapping("/container")
    public String home(Model model) {
    	model.addAttribute("student",new Student());
        return "index";
    }

//    @PostMapping("/save")
//    public String save(@Valid @ModelAttribute("student") Student saved,BindingResult result) {
//    	if(result.hasErrors()) {
//    		return "index";
//    	}
//        service.saveinfo(saved);
//        return "index";      
//    }  
    
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("student") Student saved,
                       BindingResult result,
                       Model model) {

        if(result.hasErrors()){
            return "index";
        }

        service.saveinfo(saved);

        model.addAttribute("student", new Student());
        model.addAttribute("success", true);

        return "index";
    }
}