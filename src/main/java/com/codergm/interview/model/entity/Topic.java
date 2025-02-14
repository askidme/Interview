package com.codergm.interview.model.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_seq_gen")
    @SequenceGenerator(name = "topic_seq_gen", sequenceName = "topic_seq", allocationSize = 1)
    private Long topicId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InterviewQuestion> questions;

    @ManyToOne
    @JoinColumn(name = "technology_id", nullable = false)
    private Technology technology;
}

