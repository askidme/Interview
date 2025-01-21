package com.codergm.interview.mapper;

import com.codergm.interview.model.dto.UserQuestionDTO;
import com.codergm.interview.model.entity.UserQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserQuestionMapper {
    @Mapping(target = "id.userId", source = "userId")
    @Mapping(target = "id.questionId", source = "questionId")
    UserQuestion toEntity(UserQuestionDTO dto);

    @Mapping(target = "userId", source = "id.userId")
    @Mapping(target = "questionId", source = "id.questionId")
    UserQuestionDTO toDto(UserQuestion entity);
}
