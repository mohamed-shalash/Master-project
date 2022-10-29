package com.example.master_project.Controllers;

import com.example.master_project.Models.Area;
import com.example.master_project.Models.Methedology;
import com.example.master_project.Models.Project;
import com.example.master_project.Servlets.areaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class aeaControllers {

    @Autowired
    public areaService areaService;

    @RequestMapping(value = "/area/addNew",method = {RequestMethod.GET,RequestMethod.POST})
    private String addNewStudent(Area area){
        System.out.println(area.getAccessability_to_site());
        areaService.Save(area);
        return "redirect:/project_findById?id="+area.getProjectid();
    }

    @RequestMapping(value = "/area_open",method = {RequestMethod.GET,RequestMethod.POST})
    private String addarea_open(Integer id, Model model){
        Area area =areaService.GetOne(id).get();
        model.addAttribute("area",area);
        return "adding";
    }

    @RequestMapping(value = "/area/{id}/delete",method = {RequestMethod.GET,RequestMethod.DELETE})
    private String Delete(@PathVariable int id){
        Area area =areaService.GetOne(id).get();
        areaService.Delete(id);
        return "redirect:/project_findById?id="+area.getProjectid();

    }

    @RequestMapping(value = "/analyses",method = {RequestMethod.GET,RequestMethod.POST})
    private String Criteria_page(Integer id,Model model){
        Area area =areaService.GetOne(id).get();
        model.addAttribute("area",area);
        return "data";
    }

    @RequestMapping(value = "/result1",method = {RequestMethod.GET,RequestMethod.POST})
    private String result1_page(Integer id,Model model){
        Area area =areaService.GetOne(id).get();
        model.addAttribute("area",area);
        return "data2";
    }

    @RequestMapping(value = "/result2",method = {RequestMethod.GET,RequestMethod.POST})
    private String result_page(Integer id,Model model){
        Area area =areaService.GetOne(id).get();
        model.addAttribute("area",area);

        model.addAttribute("best_fit",areaService.Fitted(area));
        return "analyse";
    }

    @RequestMapping(value = "/method",method = {RequestMethod.GET,RequestMethod.POST})
    private String project_page(String method,Model model){
        System.out.println(method);
        Methedology methedology=new Methedology(method,areaService.getDesc(method));
        model.addAttribute("way", methedology);
        return "constracts";
    }

}
