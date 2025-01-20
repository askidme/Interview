package com.codergm.interview.repository;

import com.codergm.interview.model.entity.InterviewQuestion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Long> {

    List<InterviewQuestion> findByTopic_TopicId(Long topicId);

    List<InterviewQuestion> findByTopic_TopicId(Long topicId, Pageable pageable);
}
