package com.kostin.first.dtos.user;

import com.kostin.first.entities.User;
import com.kostin.first.validation.annotation.ValidText;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class UserDtoIn extends UserBaseDto{
    @NotNull
    private Integer age;
    @NotBlank
    @Size(min = 1, max = 300)
    @ValidText
    private String text;
}
