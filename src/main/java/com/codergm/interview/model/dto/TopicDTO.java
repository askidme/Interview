package com.codergm.interview.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDTO {

    private Long topicId;
    private String title;
    private String code;
    private String description;
}
