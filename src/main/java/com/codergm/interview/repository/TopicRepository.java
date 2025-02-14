package com.codergm.interview.repository;

import com.codergm.interview.model.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByTechnology_Id(Long technologyId);
}
