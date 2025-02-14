package com.codergm.interview.controller;

import com.codergm.interview.model.ConfidenceLevel;
import com.codergm.interview.model.dto.InterviewQuestionDTO;
import com.codergm.interview.model.request.InterviewQuestionsRequest;
import com.codergm.interview.model.response.InterviewQuestionResponse;
import com.codergm.interview.service.InterviewQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class InterviewQuestionController {

    private final InterviewQuestionService interviewQuestionService;

    @GetMapping("{topicId}/{pageNumber}")
    public List<InterviewQuestionDTO> getTopicQuestions(@PathVariable long topicId, @PathVariable int pageNumber) {
        return interviewQuestionService.getQuestionsByTopicId(topicId, pageNumber, 1);
    }

    @PostMapping()
    public ResponseEntity<InterviewQuestionResponse> getQuestionIds(@RequestBody InterviewQuestionsRequest request) {
        List<Long> questionIds = interviewQuestionService.getQuestionsForTopicAndConfidence(request);
        return ok(new InterviewQuestionResponse(questionIds));
    }
//    @PostMapping({"{questionNumber}"})
//    public ResponseEntity<InterviewQuestionResponse> getQuestion(@PathVariable Integer questionNumber,
//                                                                 @RequestBody InterviewQuestionsRequest request) {
//
//        List<InterviewQuestionDTO> questions = interviewQuestionService.getQuestionsForTopicAndConfidence(request);
//        if (questionNumber <= 0 || questionNumber > questions.size())
//            return badRequest().build();
//        return ok(new InterviewQuestionResponse(questions.get(questionNumber - 1), questionNumber, questions.size()));
//    }

    @GetMapping("/confidence-levels")
    public ResponseEntity<List<ConfidenceLevel>> getConfidenceLevels() {
        return ok(List.of(ConfidenceLevel.values()));
    }

    @GetMapping("{questionId}")
    public ResponseEntity<InterviewQuestionDTO> getInterviewQuestionById(@PathVariable Long questionId) {
        return ok(interviewQuestionService.getInterviewQuestionById(questionId));
    }
}