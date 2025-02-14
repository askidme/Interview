package com.codergm.interview.model.request;

import lombok.Data;

import java.util.List;

@Data
public class InterviewQuestionsRequest {
    private Long userId;
    List<TopicConfidenceLevels> topicConfidenceLevelsList;
}
