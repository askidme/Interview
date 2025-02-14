package com.codergm.interview.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InterviewQuestionResponse {
    List<Long> questionIds;
//    private InterviewQuestionDTO interviewQuestion;
//    private Integer questionNumber;
//    private Integer totalQuestions;
}
