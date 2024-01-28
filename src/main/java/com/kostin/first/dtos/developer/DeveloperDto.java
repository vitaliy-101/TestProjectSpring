package com.kostin.first.dtos.developer;

import com.kostin.first.dtos.progLanguage.ProgLanguageDto;
import com.kostin.first.dtos.progLanguage.ProgLanguageMinDto;
import com.kostin.first.entities.ProgLanguage;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeveloperDto extends DeveloperBaseDto{
    private Integer id;
    private List<ProgLanguageMinDto> progLanguages;
}
