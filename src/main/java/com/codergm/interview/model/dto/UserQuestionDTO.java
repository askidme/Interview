package com.codergm.interview.model.dto;

import com.codergm.interview.model.ConfidenceLevel;
import lombok.Data;

@Data
public class UserQuestionDTO {

    private Long userId;
    private Long questionId;
    private boolean isCorrect;
    private ConfidenceLevel confidenceLevel;
}
