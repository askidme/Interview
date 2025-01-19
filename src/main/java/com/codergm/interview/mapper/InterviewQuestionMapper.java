package com.codergm.interview.mapper;

import com.codergm.interview.model.dto.InterviewQuestionDTO;
import com.codergm.interview.model.entity.InterviewQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InterviewQuestionMapper {

    @Mapping(target = "topic", ignore = true)
    InterviewQuestion toEntity(InterviewQuestionDTO interviewQuestionDTO);

    InterviewQuestionDTO toDto(InterviewQuestion interviewQuestion);
}
