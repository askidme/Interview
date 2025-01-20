package com.codergm.interview.service;

import com.codergm.interview.model.dto.InterviewQuestionDTO;

import java.util.List;

public interface InterviewQuestionService {

    List<InterviewQuestionDTO> getQuestionsByTopicId(Long topicId);
    List<InterviewQuestionDTO> getQuestionsByTopicId(Long topicId, int pageNumber, int pageSize);
}
