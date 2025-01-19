package com.codergm.interview.mapper;

import com.codergm.interview.model.dto.TopicDTO;
import com.codergm.interview.model.entity.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    TopicDTO toDto(Topic topic);

    @Mapping(target = "questions", ignore = true)
    Topic toEntity(TopicDTO topicDTO);
}
