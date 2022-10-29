package com.example.master_project.Servlets;

import com.example.master_project.Models.Project;
import com.example.master_project.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServelets {
    @Autowired
    private ProjectRepository projectRepository;

    public void Save(Project project){
        projectRepository.save(project);
    }

    public List<Project> GetAll(){
        return (List<Project>) projectRepository.findAll();
    }

    public Optional<Project> GetOne(int id){
        return  projectRepository.findById(id);
    }

    public void Delete(int id) {
        projectRepository.deleteById(id);
    }
}
