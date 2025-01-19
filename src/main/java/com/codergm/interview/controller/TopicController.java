package com.codergm.interview.controller;

import com.codergm.interview.model.dto.TopicDTO;
import com.codergm.interview.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping("")
    public List<TopicDTO> getAllTopics() {
        return topicService.getAllTopics();
    }
}
