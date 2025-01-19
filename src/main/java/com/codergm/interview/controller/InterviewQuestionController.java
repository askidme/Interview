package com.codergm.interview.controller;

import com.codergm.interview.model.dto.InterviewQuestionDTO;
import com.codergm.interview.service.InterviewQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class InterviewQuestionController {

    private final InterviewQuestionService interviewQuestionService;

    @GetMapping("{topicId}")
    public List<InterviewQuestionDTO> getTopicQuestions(@PathVariable long topicId) {
        return interviewQuestionService.getInterviewQuestionsByTopicId(topicId);
    }
}
