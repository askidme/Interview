package com.codergm.interview.controller;

import com.codergm.interview.model.dto.InterviewQuestionDTO;
import com.codergm.interview.service.InterviewQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class InterviewQuestionController {

    private final InterviewQuestionService interviewQuestionService;

    @GetMapping("{topicId}/{pageNumber}")
    public List<InterviewQuestionDTO> getTopicQuestions(@PathVariable long topicId, @PathVariable int pageNumber) {
        return interviewQuestionService.getQuestionsByTopicId(topicId, pageNumber, 1);
    }
}