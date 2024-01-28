package com.kostin.first.service;

import com.kostin.first.entities.Developer;
import java.util.List;

public interface DeveloperService {
    List<Developer> getAllDevelopers();
    Developer getDeveloperById(Integer id);
    Developer createDeveloper(Developer developer);
    void deleteDeveloperById(Integer id);
    Developer updateDeveloper(Developer developer, Integer id);

}
