package com.codergm.interview.service;

import com.codergm.interview.model.dto.TopicDTO;
import java.util.List;

public interface TopicService {

    List<TopicDTO> getAllTopics();

    List<TopicDTO> getTopicsByTechnology(Long techId);

    TopicDTO getTopicById(Long topicId);
}
