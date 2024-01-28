package com.kostin.first.service;

import com.kostin.first.entities.Developer;
import com.kostin.first.entities.Phone;
import com.kostin.first.entities.User;
import com.kostin.first.exceptions.FoundException;
import com.kostin.first.exceptions.NotFoundByIdException;
import com.kostin.first.repositories.DeveloperRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService{
    @Autowired
    private DeveloperRepository developerRepository;
    //попробовать сделать что то интереснее
    @Scheduled(fixedDelay = 10000, initialDelay = 5000)
    public void printDeveloperTime(){
        System.out.println("go");
    }
    public List<Developer> getAllDevelopers(){
        return developerRepository.findAll();
    }
    public Developer getDeveloperById(Integer id){
        return developerRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(Developer.class, id));
    }
    public Developer createDeveloper(Developer developer){
        if (developerRepository.existsByName(developer.getName())){
            throw new FoundException(Developer.class, developer.getName());
        }
        return developerRepository.save(developer);
    }
    public void deleteDeveloperById(Integer id){
        developerRepository.deleteById(id);
    }
    public Developer updateDeveloper(Developer developer, Integer id){
        Developer lastDeveloper = developerRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(Developer.class, id));
        if (!lastDeveloper.getName().equals(developer.getName()) && developerRepository.existsByName(developer.getName())){
            throw new FoundException(Developer.class, developer.getName());
        }
        lastDeveloper.setProgLanguages(developer.getProgLanguages());
        lastDeveloper.setName(developer.getName());
        lastDeveloper.setCountry(developer.getCountry());
        return developerRepository.save(lastDeveloper);
    }

}
