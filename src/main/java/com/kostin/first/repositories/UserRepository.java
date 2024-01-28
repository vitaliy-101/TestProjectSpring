package com.kostin.first.repositories;

import com.kostin.first.entities.Phone;
import com.kostin.first.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByName(String name);

    @Query("SELECT user From User user LEFT JOIN FETCH user.phones u")
    List<User> getAll();
}
