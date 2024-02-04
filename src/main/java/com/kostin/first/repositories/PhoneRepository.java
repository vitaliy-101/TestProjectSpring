package com.kostin.first.repositories;

import com.kostin.first.entities.Phone;
import com.kostin.first.entities.User;
import com.kostin.first.entities.view.PhoneView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {
    @Query("SELECT phone FROM Phone phone ORDER BY phone.model")
    List<Phone> getAllPhonesSort();
    @Query("SELECT phone From Phone phone LEFT JOIN FETCH phone.user u")
    List<Phone> getPhonesWithUsers();

    @Query("SELECT NEW com.kostin.first.entities.view.PhoneView (phone.id, phone.model, phone.year, u.username, u.id) From Phone phone LEFT JOIN phone.user u")

    List<PhoneView> getPhoneViews();
    boolean existsByModel(String model);

}
