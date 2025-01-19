package com.codergm.interview.service.impl;

import com.codergm.interview.mapper.InterviewQuestionMapper;
import com.codergm.interview.model.dto.InterviewQuestionDTO;
import com.codergm.interview.repository.InterviewQuestionRepository;
import com.codergm.interview.service.InterviewQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InterviewQuestionServiceImpl implements InterviewQuestionService {

    private final InterviewQuestionRepository interviewQuestionRepository;
    private final InterviewQuestionMapper interviewQuestionMapper;

    @Override
    public List<InterviewQuestionDTO> getInterviewQuestionsByTopicId(Long topicId) {
        return interviewQuestionRepository.findByTopic_TopicId(topicId)
                .stream().map(interviewQuestionMapper::toDto).toList();
    }
}
