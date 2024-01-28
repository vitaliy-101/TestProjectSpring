package com.kostin.first.service;

import com.kostin.first.entities.Phone;
import com.kostin.first.entities.view.PhoneView;
import java.util.List;

public interface PhoneService {
    List<PhoneView> getAllPhones();
    List<Phone> getAllPhonesSort();
    Phone getPhoneById(Integer id);
    Phone createPhone(Phone phone);
    void deletePhone(Integer id);
    Phone updatePhone(Phone phone, Integer id);
}
