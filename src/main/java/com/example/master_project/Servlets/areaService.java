package com.example.master_project.Servlets;

import com.example.master_project.Models.Area;
import com.example.master_project.Repository.areaRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class areaService {
    @Autowired
    private areaRepository areaRepository;

    public void Save(Area area){
        areaRepository.save(area);
    }

    public List<Area> GetAll(){
        return (List<Area>) areaRepository.findAll();
    }

    public List<Area> Getsomeby_project_id(int proid){
        return (List<Area>) areaRepository.findAllByProjectId(proid);
    }

    public Optional<Area> GetOne(int id){
        return  areaRepository.findById(id);
    }

    public void Delete(int id) {
        areaRepository.deleteById(id);
    }

    public List<String> Fitted(Area area){
        List<String> fit =new ArrayList<>();
        if(area.getHorizontal_Alignment().equals("small to medium curvature")&&area.getBridge_Span_length().equals("20-50 m"))
            fit.add("Precast Span by Span using launching Girder");
        if(!area.getSoil_condition().equals("weak")&&
                area.getBridge_Span_length().equals("20-50 m")&&
                area.getHorizontal_Alignment().equals("small to medium curvature"))
            fit.add("Full Span Launching Method");

        if(area.getNature_of_crossing().equals("Highway" )&& area.getAccessability_to_site().equals("ease access")&&!area.getSoil_condition().equals("weak")&&
        area.getVolume_of_Traffic_During_Construction().equals("Moderate" )&& !area.getLand_tepography_range().equals("more than 400 cm")&&
                !area.getBridge_hight_above_ground().equals("more than 20 m")&&area.getBridge_Span_length().equals("50-200 m")&&area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering"))
            fit.add("Free Cantilever precast using  lifting frame and formwork ");

        if(!area.getNature_of_crossing().equals("Railway")&&(area.getBridge_Span_length().equals("50-200 m")||area.getBridge_Span_length().equals("more than 200 m")))
            fit.add("Balanced Cantilever cast in situ using two travelers");

        if(area.getBridge_Span_length().equals("50-200 m")||area.getBridge_Span_length().equals("more than 200 m"))
            fit.add("Balanced Cantilever precast using lifting frames ");

        if(area.getHorizontal_Alignment().equals("small to medium curvature")&&area.getBridge_Span_length().equals("20-50 m"))
            fit.add("Precast Incremental launching");


        if((area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("50-200 m"))&&area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering")
                &&!area.getBridge_hight_above_ground().equals("more than 20 m")&&area.getLand_tepography_range().equals("0 - 200 cm")&&
        area.getVolume_of_Traffic_During_Construction().equals("Moderate")&&area.getNature_of_crossing().equals("Highway"))
            fit.add("Cast in Situ segment  using formwork supported on ground");
        if(area.getNature_of_crossing().equals("Highway")&&!area.getSoil_condition().equals("weak")&&area.getVolume_of_Traffic_During_Construction().equals("Moderate"
                )&&area.getLand_tepography_range().equals("0 - 200 cm")&&!area.getBridge_hight_above_ground().equals("more than 20 m")&&
                (area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("0-20 m"))&&area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering"))
            fit.add("Reinforced Concrete (RC) cast in situ girder");

        if(!area.getNature_of_crossing().equals("Railway")&&(area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("0-20 m"))&&
                area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering")&&area.getHorizontal_Alignment().equals("small to medium curvature")&&
                !area.getLand_tepography_range().equals("more than 400 cm")&& area.getAccessability_to_site().equals("ease access"))
            fit.add("precast post tension girder");
////////////////////////////////////////////////////////
        if(area.getNature_of_crossing().equals("Highway")&&(area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("0-20 m"))&&
                area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering")&&!area.getBridge_hight_above_ground().equals("more than 20 m")
            &&area.getHorizontal_Alignment().equals("small to medium curvature")
        &&area.getVolume_of_Traffic_During_Construction().equals("Moderate")&&area.getLand_tepography_range().equals("0 - 200 cm")
        )
            fit.add("cast in situ post tension girde");


        if(area.getNature_of_crossing().equals("Highway")&&(area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("0-20 m"))&&
                area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering")
                &&!area.getBridge_hight_above_ground().equals("more than 20 m")&&
                area.getLand_tepography_range().equals("0 - 200 cm")
                &&!area.getSoil_condition().equals("weak")&&area.getLand_tepography_range().equals("0 - 200 cm")
                &&area.getVolume_of_Traffic_During_Construction().equals("Moderate"))
            fit.add("Hollow core slab cast in situ");
        ////////////////////////////////////////////////////
        return fit;
    }

    public String getDesc(String method){
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("methods.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("method");
            System.out.println(name);

            long age = (Long) jsonObject.get("description");
            System.out.println(age);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
