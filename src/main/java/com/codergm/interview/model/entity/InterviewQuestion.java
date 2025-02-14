package com.codergm.interview.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "interview_questions")
public class InterviewQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_quest_seq_gen")
    @SequenceGenerator(name = "interview_quest_seq_gen", sequenceName = "interview_quest_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;
}