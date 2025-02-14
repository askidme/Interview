package com.codergm.interview.mapper;

import com.codergm.interview.model.dto.TechnologyDTO;
import com.codergm.interview.model.entity.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {

    TechnologyDTO toDto(Technology entity);

    @Mapping(target = "topics", ignore = true)
    Technology toEntity(TechnologyDTO dto);
}
