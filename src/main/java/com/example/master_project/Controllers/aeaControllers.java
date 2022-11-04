package com.example.master_project.Controllers;

import com.example.master_project.Models.Area;
import com.example.master_project.Models.Methedology;
import com.example.master_project.Models.Project;
import com.example.master_project.Models.Weight;
import com.example.master_project.Servlets.areaService;
import com.example.master_project.topcies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class aeaControllers {

    @Autowired
    public areaService areaService;
    List<Weight> Cerateria_values;
    Weight weights;

    Topsis topsis=new Topsis();

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

    @GetMapping("/processing")
    private String area_page(int id,int counter,int state,String method,Model model){
        Area area = areaService.GetOne(id).get();
        model.addAttribute("area", area);
        model.addAttribute("new_num", counter+1);
        model.addAttribute("x", state);
        model.addAttribute("method", method);
        model.addAttribute("weight", weights);

        List<String> methods = areaService.Fitted(area);

        for (int i=0;i< Cerateria_values.size();i++){
            Cerateria_values.get(i).setMethod(methods.get(i));
        }
        //model.addAttribute("methods", methods);
        model.addAttribute("names", Cerateria_values);

        return "processing";
    }

    @GetMapping("/result")
    private String Result(int id,Model model){
        /*
        1.Certeria_values  List<Weight> rad values
        2.weights  List<Weight>
        3.methods
        */
        Area area = areaService.GetOne(id).get();
        List<String> methods = areaService.Fitted(area);
        /*
        *
        * */
        List<Criteria> clist=new config().criteria;

        for (int j=0;j<Cerateria_values.size();j++) {
            Alternative alternative=new Alternative();
            for (int i = 0; i < 17; i++) {//[]
                alternative.addCriteriaValue(new CriteriaValue(new Criteria(clist.get(i).getName(),weights.getList().get(i)),
                        Cerateria_values.get(j).getList().get(i)));
            }
            topsis.addAlternative(alternative);
        }

        try{
            System.out.println(topsis.calculateOptimalSolutionSortedList());
            topsis.writeResultsIntoCSVFile("C:\\Users\\tshal\\Desktop","koko");

        }catch (Exception ex){
            System.out.println(ex);
        }
        topsis=new Topsis();
        return "Result";
    }

    @RequestMapping(value = "/{counter}/{id}/Area_areaId",method = {RequestMethod.GET,RequestMethod.POST})
    private String processing(@PathVariable int counter, @PathVariable int id, Weight weight, Model model) {

        Area area = areaService.GetOne(id).get();
        List<String> methods = areaService.Fitted(area);

        model.addAttribute("area", area);



        if (counter == methods.size()+1) {
            Cerateria_values.add(weight);
            return "redirect:/result?id="+id;
        } else if (counter == 0) {
            Cerateria_values = new ArrayList<>();

            return "redirect:/processing?id="+id+"&counter="+counter+"&state="+1+"&method=weight";
        } else if (counter == 1) {
            weights=weight;
            //weight.getall();
            return "redirect:/processing?id="+id+"&counter="+counter+"&state="+0+"&method="+methods.get(counter-1);
        } else {
            Cerateria_values.add(weight);
            //System.out.println("here " + counter);
            model.addAttribute("methods", methods.get(counter-1));
            return "redirect:/processing?id="+id+"&counter="+counter+"&state="+0+"&method="+methods.get(counter-1);
        }

 }

}
