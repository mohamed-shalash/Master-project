package com.example.master_project.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String Nature_of_crossing;
    private String Surrounding_area_nature;
    private String Accessability_to_site;
    private String Soil_condition;
    private String Volume_of_Traffic_During_Construction;
    private String land_tepography_range;
    private String Bridge_hight_above_ground;
    private String Horizontal_Alignment;
    private String Bridge_Span_length;
    private String Cranes_capacity_and_maneuvering;

    @ManyToOne
    @JoinColumn(name = "projectid",insertable = false,updatable = false)
    private Project project;
    private int projectid;

    public Area(int id,String name, String nature_of_crossing, String surrounding_area_nature, String accessability_to_site, String soil_condition, String volume_of_Traffic_During_Construction, String land_tepography_range, String bridge_hight_above_ground, String horizontal_Alignment, String bridge_Span_length, String cranes_capacity_and_maneuvering, int projectid) {
        this.id = id;
        Nature_of_crossing = nature_of_crossing;
        Surrounding_area_nature = surrounding_area_nature;
        Accessability_to_site = accessability_to_site;
        Soil_condition = soil_condition;
        Volume_of_Traffic_During_Construction = volume_of_Traffic_During_Construction;
        this.land_tepography_range = land_tepography_range;
        Bridge_hight_above_ground = bridge_hight_above_ground;
        Horizontal_Alignment = horizontal_Alignment;
        Bridge_Span_length = bridge_Span_length;
        Cranes_capacity_and_maneuvering = cranes_capacity_and_maneuvering;
        this.projectid = projectid;
        this.name=name;
    }

    public Area(String name,String nature_of_crossing, String surrounding_area_nature, String accessability_to_site, String soil_condition, String volume_of_Traffic_During_Construction, String land_tepography_range, String bridge_hight_above_ground, String horizontal_Alignment, String bridge_Span_length, String cranes_capacity_and_maneuvering, int projectid) {
        Nature_of_crossing = nature_of_crossing;
        Surrounding_area_nature = surrounding_area_nature;
        Accessability_to_site = accessability_to_site;
        Soil_condition = soil_condition;
        Volume_of_Traffic_During_Construction = volume_of_Traffic_During_Construction;
        this.land_tepography_range = land_tepography_range;
        Bridge_hight_above_ground = bridge_hight_above_ground;
        Horizontal_Alignment = horizontal_Alignment;
        Bridge_Span_length = bridge_Span_length;
        Cranes_capacity_and_maneuvering = cranes_capacity_and_maneuvering;
        this.projectid = projectid;
        this.name=name;
    }

    public Area(String name,String nature_of_crossing, String surrounding_area_nature, String accessability_to_site, String soil_condition, String volume_of_Traffic_During_Construction, String land_tepography_range, String bridge_hight_above_ground, String horizontal_Alignment, String bridge_Span_length, String cranes_capacity_and_maneuvering) {
        Nature_of_crossing = nature_of_crossing;
        this.name=name;
        Surrounding_area_nature = surrounding_area_nature;
        Accessability_to_site = accessability_to_site;
        Soil_condition = soil_condition;
        Volume_of_Traffic_During_Construction = volume_of_Traffic_During_Construction;
        this.land_tepography_range = land_tepography_range;
        Bridge_hight_above_ground = bridge_hight_above_ground;
        Horizontal_Alignment = horizontal_Alignment;
        Bridge_Span_length = bridge_Span_length;
        Cranes_capacity_and_maneuvering = cranes_capacity_and_maneuvering;
    }



    public Area(int id,String name, String nature_of_crossing, String surrounding_area_nature, String accessability_to_site, String soil_condition, String volume_of_Traffic_During_Construction, String land_tepography_range, String bridge_hight_above_ground, String horizontal_Alignment, String bridge_Span_length, String cranes_capacity_and_maneuvering) {
        this.id = id;
        this.name=name;
        Nature_of_crossing = nature_of_crossing;
        Surrounding_area_nature = surrounding_area_nature;
        Accessability_to_site = accessability_to_site;
        Soil_condition = soil_condition;
        Volume_of_Traffic_During_Construction = volume_of_Traffic_During_Construction;
        this.land_tepography_range = land_tepography_range;
        Bridge_hight_above_ground = bridge_hight_above_ground;
        Horizontal_Alignment = horizontal_Alignment;
        Bridge_Span_length = bridge_Span_length;
        Cranes_capacity_and_maneuvering = cranes_capacity_and_maneuvering;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNature_of_crossing() {
        return Nature_of_crossing;
    }

    public void setNature_of_crossing(String nature_of_crossing) {
        Nature_of_crossing = nature_of_crossing;
    }

    public String getSurrounding_area_nature() {
        return Surrounding_area_nature;
    }

    public void setSurrounding_area_nature(String surrounding_area_nature) {
        Surrounding_area_nature = surrounding_area_nature;
    }

    public String getAccessability_to_site() {
        return Accessability_to_site;
    }

    public void setAccessability_to_site(String accessability_to_site) {
        Accessability_to_site = accessability_to_site;
    }

    public String getSoil_condition() {
        return Soil_condition;
    }

    public void setSoil_condition(String soil_condition) {
        Soil_condition = soil_condition;
    }

    public String getVolume_of_Traffic_During_Construction() {
        return Volume_of_Traffic_During_Construction;
    }

    public void setVolume_of_Traffic_During_Construction(String volume_of_Traffic_During_Construction) {
        Volume_of_Traffic_During_Construction = volume_of_Traffic_During_Construction;
    }

    public String getLand_tepography_range() {
        return land_tepography_range;
    }

    public void setLand_tepography_range(String land_tepography_range) {
        this.land_tepography_range = land_tepography_range;
    }

    public String getBridge_hight_above_ground() {
        return Bridge_hight_above_ground;
    }

    public void setBridge_hight_above_ground(String bridge_hight_above_ground) {
        Bridge_hight_above_ground = bridge_hight_above_ground;
    }

    public String getHorizontal_Alignment() {
        return Horizontal_Alignment;
    }

    public void setHorizontal_Alignment(String horizontal_Alignment) {
        Horizontal_Alignment = horizontal_Alignment;
    }

    public String getBridge_Span_length() {
        return Bridge_Span_length;
    }

    public void setBridge_Span_length(String bridge_Span_length) {
        Bridge_Span_length = bridge_Span_length;
    }

    public String getCranes_capacity_and_maneuvering() {
        return Cranes_capacity_and_maneuvering;
    }

    public void setCranes_capacity_and_maneuvering(String cranes_capacity_and_maneuvering) {
        Cranes_capacity_and_maneuvering = cranes_capacity_and_maneuvering;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }
}


   /*
    student_table

    @ManyToOne
    @JoinColumn(name = "yearid",insertable = false,updatable = false)
    private Year year;

    @JsonBackReference
    public Year getYear()

    */

    /*
    Year_table

    @OneToMany(mappedBy = "year",cascade = CascadeType.ALL)
    private List<Student> students;

    @JsonManagedReference //or ignore
    public List<Student> getStudents() {
        return students;
    }

    */