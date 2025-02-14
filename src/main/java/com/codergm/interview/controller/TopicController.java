package com.codergm.interview.controller;

import com.codergm.interview.model.dto.TopicDTO;
import com.codergm.interview.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping("")
    public List<TopicDTO> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/by-tech/{techId}")
    public ResponseEntity<List<TopicDTO>> getTopicsByTechnology(@PathVariable Long techId) {
        return ok(topicService.getTopicsByTechnology(techId));
    }
    
    @GetMapping("{topicId}")
    public ResponseEntity<TopicDTO> getTopic(@PathVariable Long topicId) {
        return ok(topicService.getTopicById(topicId));
    }
}
