package com.kostin.first.service;

import com.kostin.first.entities.Phone;
import com.kostin.first.entities.view.PhoneView;
import com.kostin.first.exceptions.FoundException;
import com.kostin.first.exceptions.NotFoundByIdException;
import com.kostin.first.repositories.PhoneRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@Transactional
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    private PhoneRepository phoneRepository;

    public List<PhoneView> getAllPhones(){
        return phoneRepository.getPhoneViews();
    }
    public List<Phone> getAllPhonesSort(){
        return phoneRepository.getAllPhonesSort();
    }
    public Phone getPhoneById(Integer id){
        return phoneRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(Phone.class, id));
    }

    public Phone createPhone(Phone phone){
        if (phoneRepository.existsByModel(phone.getModel())){
            throw new FoundException(Phone.class, phone.getModel());
        }
        return phoneRepository.save(phone);
    }
    public void deletePhone(Integer id){
        phoneRepository.deleteById(id);
    }
    public Phone updatePhone(Phone phone, Integer id) {
        Phone lastPhone = phoneRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(Phone.class, id));
        if (!lastPhone.getModel().equals(phone.getModel()) && phoneRepository.existsByModel(phone.getModel())){
            throw new FoundException(Phone.class, phone.getModel());
        }
        lastPhone.setUser(phone.getUser());
        lastPhone.setModel(phone.getModel());
        lastPhone.setYear(phone.getYear());
        return phoneRepository.save(lastPhone);
        
    }




}
