package com.codergm.interview.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technology_seq_gen")
    @SequenceGenerator(name = "technology_seq_gen", sequenceName = "technology_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    @OneToMany(mappedBy = "technology", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topic> topics;
}
