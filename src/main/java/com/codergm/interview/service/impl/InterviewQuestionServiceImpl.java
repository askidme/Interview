package com.codergm.interview.service.impl;

import com.codergm.interview.mapper.InterviewQuestionMapper;
import com.codergm.interview.model.dto.InterviewQuestionDTO;
import com.codergm.interview.model.entity.InterviewQuestion;
import com.codergm.interview.model.request.InterviewQuestionsRequest;
import com.codergm.interview.repository.InterviewQuestionRepository;
import com.codergm.interview.service.InterviewQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InterviewQuestionServiceImpl implements InterviewQuestionService {

    private final InterviewQuestionRepository interviewQuestionRepository;
    private final InterviewQuestionMapper interviewQuestionMapper;

    @Override
    public List<InterviewQuestionDTO> getQuestionsByTopicId(Long topicId) {

        return interviewQuestionRepository.findByTopic_TopicId(topicId)
                .stream().map(interviewQuestionMapper::toDto).toList();
    }

    @Override
    public List<InterviewQuestionDTO> getQuestionsByTopicId(Long topicId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return interviewQuestionRepository.findByTopic_TopicId(topicId, pageable)
                .stream().map(interviewQuestionMapper::toDto).toList();
    }

    @Override
    public List<Long> getQuestionsForTopicAndConfidence(InterviewQuestionsRequest request) {
        return request.getTopicConfidenceLevelsList().stream()
                .flatMap(topicConfidenceLevels ->
                        interviewQuestionRepository.findByTopicAndOptionalConfidenceLevels(topicConfidenceLevels.getTopicId(),
                                request.getUserId(),
                                topicConfidenceLevels.getConfidenceLevels()).stream())
            .map(InterviewQuestion::getId).toList();
    }

    @Override
    public InterviewQuestionDTO getInterviewQuestionById(Long questionId) {
        return interviewQuestionRepository.findById(questionId).map(interviewQuestionMapper::toDto).orElse(null);
    }
}
