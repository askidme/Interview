package com.codergm.interview.model.request;

import com.codergm.interview.model.ConfidenceLevel;
import lombok.Data;

import java.util.List;

@Data
public class TopicConfidenceLevels {
    private Long topicId;
    private List<ConfidenceLevel> confidenceLevels;
}
