package com.kostin.first.entities.view;

import lombok.Getter;

@Getter

public class UserView {
    private String name;
    private Integer id;

    public UserView(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
