package com.kostin.first.dtos.phone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDtoIn extends PhoneBaseDto{
    @NotNull
    private Integer userId;
}
