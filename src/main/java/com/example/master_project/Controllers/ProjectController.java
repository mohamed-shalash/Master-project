package com.example.master_project.Controllers;

import com.example.master_project.Models.Area;
import com.example.master_project.Models.Project;
import com.example.master_project.Servlets.ProjectServelets;
import com.example.master_project.Servlets.areaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class ProjectController {

    @Autowired
    public ProjectServelets projectServelets;
   /* @Autowired
    public areaService areaService;*/

    @GetMapping("/project")
    private String project_main(Model model){
        model.addAttribute("Project", projectServelets.GetAll());
        return "main";
    }

    @RequestMapping(value = "/project_findById",method = {RequestMethod.GET,RequestMethod.POST})
    private String project_page(Integer id,Model model){
       // System.out.println(id);
        Project project=projectServelets.GetOne(id).get();
        Date date =Date.valueOf(project.getDate().toString().substring(0, 10));
        project.setDate(date);
       model.addAttribute("project", project);
        return "project";
    }


    @RequestMapping(value = "/area_add",method = {RequestMethod.GET,RequestMethod.POST})
    private String addarea_page(Integer id,Model model){
        Area area =new Area("","Highway","Downtown","ease access","strong","Moderate","0 - 200 cm","0- 7 m","small to medium curvature","0-20 m","require area for maneuvering",id);
        model.addAttribute("area",area);
        //System.out.println(id);
        return "adding";
    }



    @RequestMapping(value = "/project/addNew",method = {RequestMethod.GET,RequestMethod.POST})
    private String addNewStudent(Project project){
       // System.out.println(project.getCity());
        projectServelets.Save(project);
        return "redirect:/project";
    }
    @RequestMapping(value = "/project/{id}/delete",method = {RequestMethod.GET,RequestMethod.DELETE})
    private String Delete(@PathVariable int id){
       // System.out.println(id);
        projectServelets.Delete(id);
        return "redirect:/project";

    }
}

/*
    @Autowired
    private StudentServices studentServices;

    @Autowired
    private YearService yearService;

    @GetMapping("/student")
    private String getAllStudents(Model model){
        model.addAttribute("student", studentServices.GetAll());
        model.addAttribute("year", yearService.GetAll());
        System.out.println( studentServices.GetAll());
        return "Student";
    }

    //@PostMapping("/student/addNew")
    @RequestMapping(value = "/student/addNew",method = {RequestMethod.GET,RequestMethod.POST})
    private String addNewStudent(Student student){
        System.out.println(student.getYearid());
        studentServices.AddStudentOrUpdate(student);
        return "redirect:/student";
    }

    //@PutMapping("/student/update")
    @RequestMapping(value = "/student/update",method = {RequestMethod.GET,RequestMethod.PUT})
    private String Update(Student student){
        //System.out.println(student.getName());
        studentServices.AddStudentOrUpdate(student);
        return "redirect:/student";
    }



    @RequestMapping("home/findById")
    @ResponseBody
    public Optional<TODO_LIST> findById(Integer id )
    {
        return studentService.findById(id);
    }
*/
