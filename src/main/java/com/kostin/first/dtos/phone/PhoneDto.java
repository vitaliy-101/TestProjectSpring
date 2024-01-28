package com.kostin.first.dtos.phone;

import com.kostin.first.dtos.user.UserMinDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDto extends PhoneBaseDto{
    private Integer id;
    private UserMinDto user;
}
