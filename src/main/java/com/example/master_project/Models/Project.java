package com.example.master_project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String owner;
    private String Country;
    private String city;
    private String street;
    private String description;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private List<Area> areas;


    public Project(int id, String name, String owner, String country, String city, String street, String description, Date date) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        Country = country;
        this.city = city;
        this.street = street;
        this.description = description;
        this.date = date;
    }

    public Project(String name, String owner, String country, String city, String street, String description, Date date) {
        this.name = name;
        this.owner = owner;
        Country = country;
        this.city = city;
        this.street = street;
        this.description = description;
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonIgnore
    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
