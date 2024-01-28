package com.kostin.first.dtos.developer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeveloperBaseDto {
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @NotBlank
    @Size(min = 1, max = 120)
    private String country;
}
