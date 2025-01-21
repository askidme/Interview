package com.codergm.interview.model.entity;

import com.codergm.interview.model.ConfidenceLevel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_questions")
public class UserQuestion {

    @EmbeddedId
    private UserQuestionId id;

    @Column()
    private boolean isCorrect;

    @Enumerated(EnumType.STRING)
    private ConfidenceLevel confidenceLevel;
}
