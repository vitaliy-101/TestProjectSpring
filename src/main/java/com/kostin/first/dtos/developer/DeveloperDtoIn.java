package com.kostin.first.dtos.developer;

import com.kostin.first.dtos.progLanguage.ProgLanguageBaseDto;
import com.kostin.first.dtos.progLanguage.ProgLanguageDtoIn;
import com.kostin.first.dtos.progLanguage.ProgLanguageMinDto;
import com.kostin.first.entities.ProgLanguage;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeveloperDtoIn extends DeveloperBaseDto{
    @NotNull
    private List<Integer> progLanguagesIds;
}
