package com.codergm.interview.service;

import com.codergm.interview.model.dto.InterviewQuestionDTO;
import com.codergm.interview.model.request.InterviewQuestionsRequest;

import java.util.List;

public interface InterviewQuestionService {

    List<InterviewQuestionDTO> getQuestionsByTopicId(Long topicId);

    List<InterviewQuestionDTO> getQuestionsByTopicId(Long topicId, int pageNumber, int pageSize);

    List<Long>  getQuestionsForTopicAndConfidence(InterviewQuestionsRequest request);

    InterviewQuestionDTO getInterviewQuestionById(Long questionId);
}
