package com.kostin.first.dtos.progLanguage;

import com.kostin.first.dtos.developer.DeveloperMinDto;
import com.kostin.first.entities.Developer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgLanguageDto extends ProgLanguageBaseDto{
    private Integer id;
    private List<DeveloperMinDto> developers;
}
