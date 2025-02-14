package com.codergm.interview.service.impl;

import com.codergm.interview.mapper.TopicMapper;
import com.codergm.interview.model.dto.TopicDTO;
import com.codergm.interview.repository.TopicRepository;
import com.codergm.interview.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Override
    public List<TopicDTO> getAllTopics() {
        return topicRepository.findAll().stream().map(topicMapper::toDto).toList();
    }

    @Override
    public List<TopicDTO> getTopicsByTechnology(Long techId) {
        return topicRepository.findByTechnology_Id(techId).stream().map(topicMapper::toDto).toList();
    }

    public TopicDTO getTopicById(Long topicId) {
        return topicRepository.findById(topicId).map(topicMapper::toDto).orElse(null);
    }
}
