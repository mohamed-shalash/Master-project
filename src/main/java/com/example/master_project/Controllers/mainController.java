package com.example.master_project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class mainController {

    @GetMapping("/")
    public String main_page(){
        return "redirect:/project";
    }

    @GetMapping("/project/{id}")
    public String pro_page(@PathVariable int id, Model model){
        return "project";
    }

    @GetMapping("/area")
    public String add_page(){
        return "adding";
    }
}
