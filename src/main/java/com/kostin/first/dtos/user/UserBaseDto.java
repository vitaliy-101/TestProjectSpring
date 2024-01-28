package com.kostin.first.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UserBaseDto {
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
}
