package com.kostin.first.dtos.user;

import com.kostin.first.dtos.phone.PhoneDto;
import com.kostin.first.dtos.phone.PhoneMinDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends UserBaseDto{
    private Integer id;
    private Integer age;
    private String text;
    private List<PhoneMinDto> phones;
}
