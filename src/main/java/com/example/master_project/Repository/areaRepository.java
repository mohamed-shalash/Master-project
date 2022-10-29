package com.example.master_project.Repository;

import com.example.master_project.Models.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface areaRepository  extends CrudRepository<Area,Integer> {
    public List<Area> findAllByProjectId(int id);
}
