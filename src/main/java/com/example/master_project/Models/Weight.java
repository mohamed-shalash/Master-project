package com.example.master_project.Models;

import java.util.ArrayList;
import java.util.List;

public class Weight {
    Double Speed_of_construction;
    Double Availability_of_Equipment;
    Double Effect_of_construction_on_design;
    Double Budget_Cost;
    Double Availability_of_material;
    Double degree_of_Risk_during_construction;
    Double latest_technology_forWorld_vision;
    Double cost_of_maintenace;
    Double Life_cycle_cost;
    Double Availability_of_skilled_manpower;
    Double Ease_of_Maintenance;
    Double Contractor_experience_and_capabilities;
    Double Diversion_cost_of_Existing_utilities;
    Double future_extension;
    Double Aesthetics_of_bridge;
    Double difficulty_in_logestics;
    Double communication_complexity_level_bewteen_Different_parties;

    public Weight(Double speed_of_construction, Double availability_of_Equipment, Double effect_of_construction_on_design, Double budget_Cost, Double availability_of_material, Double degree_of_Risk_during_construction, Double latest_technology_forWorld_vision, Double cost_of_maintenace, Double life_cycle_cost, Double availability_of_skilled_manpower, Double ease_of_Maintenance, Double contractor_experience_and_capabilities, Double diversion_cost_of_Existing_utilities, Double future_extension, Double aesthetics_of_bridge, Double difficulty_in_logestics, Double communication_complexity_level_bewteen_Different_parties) {
        Speed_of_construction = speed_of_construction;
        Availability_of_Equipment = availability_of_Equipment;
        Effect_of_construction_on_design = effect_of_construction_on_design;
        Budget_Cost = budget_Cost;
        Availability_of_material = availability_of_material;
        this.degree_of_Risk_during_construction = degree_of_Risk_during_construction;
        this.latest_technology_forWorld_vision = latest_technology_forWorld_vision;
        this.cost_of_maintenace = cost_of_maintenace;
        Life_cycle_cost = life_cycle_cost;
        Availability_of_skilled_manpower = availability_of_skilled_manpower;
        Ease_of_Maintenance = ease_of_Maintenance;
        Contractor_experience_and_capabilities = contractor_experience_and_capabilities;
        Diversion_cost_of_Existing_utilities = diversion_cost_of_Existing_utilities;
        this.future_extension = future_extension;
        Aesthetics_of_bridge = aesthetics_of_bridge;
        this.difficulty_in_logestics = difficulty_in_logestics;
        this.communication_complexity_level_bewteen_Different_parties = communication_complexity_level_bewteen_Different_parties;
    }

    public Weight() {
    }

    public Double getSpeed_of_construction() {
        return Speed_of_construction;
    }

    public void setSpeed_of_construction(Double speed_of_construction) {
        Speed_of_construction = speed_of_construction;
    }

    public Double getAvailability_of_Equipment() {
        return Availability_of_Equipment;
    }

    public void setAvailability_of_Equipment(Double availability_of_Equipment) {
        Availability_of_Equipment = availability_of_Equipment;
    }

    public Double getEffect_of_construction_on_design() {
        return Effect_of_construction_on_design;
    }

    public void setEffect_of_construction_on_design(Double effect_of_construction_on_design) {
        Effect_of_construction_on_design = effect_of_construction_on_design;
    }

    public Double getBudget_Cost() {
        return Budget_Cost;
    }

    public void setBudget_Cost(Double budget_Cost) {
        Budget_Cost = budget_Cost;
    }

    public Double getAvailability_of_material() {
        return Availability_of_material;
    }

    public void setAvailability_of_material(Double availability_of_material) {
        Availability_of_material = availability_of_material;
    }

    public Double getDegree_of_Risk_during_construction() {
        return degree_of_Risk_during_construction;
    }

    public void setDegree_of_Risk_during_construction(Double degree_of_Risk_during_construction) {
        this.degree_of_Risk_during_construction = degree_of_Risk_during_construction;
    }

    public Double getLatest_technology_forWorld_vision() {
        return latest_technology_forWorld_vision;
    }

    public void setLatest_technology_forWorld_vision(Double latest_technology_forWorld_vision) {
        this.latest_technology_forWorld_vision = latest_technology_forWorld_vision;
    }

    public Double getCost_of_maintenace() {
        return cost_of_maintenace;
    }

    public void setCost_of_maintenace(Double cost_of_maintenace) {
        this.cost_of_maintenace = cost_of_maintenace;
    }

    public Double getLife_cycle_cost() {
        return Life_cycle_cost;
    }

    public void setLife_cycle_cost(Double life_cycle_cost) {
        Life_cycle_cost = life_cycle_cost;
    }

    public Double getAvailability_of_skilled_manpower() {
        return Availability_of_skilled_manpower;
    }

    public void setAvailability_of_skilled_manpower(Double availability_of_skilled_manpower) {
        Availability_of_skilled_manpower = availability_of_skilled_manpower;
    }

    public Double getEase_of_Maintenance() {
        return Ease_of_Maintenance;
    }

    public void setEase_of_Maintenance(Double ease_of_Maintenance) {
        Ease_of_Maintenance = ease_of_Maintenance;
    }

    public Double getContractor_experience_and_capabilities() {
        return Contractor_experience_and_capabilities;
    }

    public void setContractor_experience_and_capabilities(Double contractor_experience_and_capabilities) {
        Contractor_experience_and_capabilities = contractor_experience_and_capabilities;
    }

    public Double getDiversion_cost_of_Existing_utilities() {
        return Diversion_cost_of_Existing_utilities;
    }

    public void setDiversion_cost_of_Existing_utilities(Double diversion_cost_of_Existing_utilities) {
        Diversion_cost_of_Existing_utilities = diversion_cost_of_Existing_utilities;
    }

    public Double getFuture_extension() {
        return future_extension;
    }

    public void setFuture_extension(Double future_extension) {
        this.future_extension = future_extension;
    }

    public Double getAesthetics_of_bridge() {
        return Aesthetics_of_bridge;
    }

    public void setAesthetics_of_bridge(Double aesthetics_of_bridge) {
        Aesthetics_of_bridge = aesthetics_of_bridge;
    }

    public Double getDifficulty_in_logestics() {
        return difficulty_in_logestics;
    }

    public void setDifficulty_in_logestics(Double difficulty_in_logestics) {
        this.difficulty_in_logestics = difficulty_in_logestics;
    }

    public Double getCommunication_complexity_level_bewteen_Different_parties() {
        return communication_complexity_level_bewteen_Different_parties;
    }

    public void setCommunication_complexity_level_bewteen_Different_parties(Double communication_complexity_level_bewteen_Different_parties) {
        this.communication_complexity_level_bewteen_Different_parties = communication_complexity_level_bewteen_Different_parties;
    }

    public void getall() {
        System.out.println( Speed_of_construction);
        System.out.println( Availability_of_Equipment);
        System.out.println( Effect_of_construction_on_design);
        System.out.println( Budget_Cost);
        System.out.println( Availability_of_material);
        System.out.println( degree_of_Risk_during_construction);
        System.out.println( latest_technology_forWorld_vision);
        System.out.println( cost_of_maintenace);
        System.out.println( Life_cycle_cost);
        System.out.println( Availability_of_skilled_manpower);
        System.out.println( Ease_of_Maintenance);
        System.out.println( Contractor_experience_and_capabilities);
        System.out.println( Diversion_cost_of_Existing_utilities);
        System.out.println( future_extension);
        System.out.println( Aesthetics_of_bridge);
        System.out.println( difficulty_in_logestics);
        System.out.println( communication_complexity_level_bewteen_Different_parties);
    }

    String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public  List<Double> getList() {
        List<Double> list=new ArrayList<>();
        list.add( Speed_of_construction);
        list.add( Availability_of_Equipment);
        list.add( Effect_of_construction_on_design);
        list.add( Budget_Cost);
        list.add( Availability_of_material);
        list.add( degree_of_Risk_during_construction);
        list.add( latest_technology_forWorld_vision);
        list.add( cost_of_maintenace);
        list.add( Life_cycle_cost);
        list.add( Availability_of_skilled_manpower);
        list.add( Ease_of_Maintenance);
        list.add( Contractor_experience_and_capabilities);
        list.add( Diversion_cost_of_Existing_utilities);
        list.add( future_extension);
        list.add( Aesthetics_of_bridge);
        list.add( difficulty_in_logestics);
        list.add( communication_complexity_level_bewteen_Different_parties);
        return list;
    }

}
