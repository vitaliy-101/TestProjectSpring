package com.kostin.first.entities.view;

import com.kostin.first.dtos.user.UserMinDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneView {
    private Integer id;
    private String model;
    private Integer year;
    private UserView user;

    public PhoneView(Integer id, String model, Integer year, String name, Integer user_id) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.user = new UserView(name, user_id);
    }
}
