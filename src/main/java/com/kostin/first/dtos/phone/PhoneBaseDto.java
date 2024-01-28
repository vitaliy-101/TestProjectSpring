package com.kostin.first.dtos.phone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public abstract class PhoneBaseDto {
    @NotBlank
    @Size(min = 1, max = 120)
    private String model;
    @NotNull
    private Integer year;
}
