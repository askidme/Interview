package com.codergm.interview.repository;

import com.codergm.interview.model.ConfidenceLevel;
import com.codergm.interview.model.entity.InterviewQuestion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Long> {

    List<InterviewQuestion> findByTopic_TopicId(Long topicId);

    List<InterviewQuestion> findByTopic_TopicId(Long topicId, Pageable pageable);


    @Query(" SELECT iq FROM InterviewQuestion iq LEFT JOIN UserQuestion uq " +
            "   ON uq.id.questionId = iq.id AND uq.id.userId = :userId " +
            "   WHERE iq.topic.topicId = :topicId " +
            "       AND (:confidenceLevels IS NULL OR uq.confidenceLevel IN :confidenceLevels)")
    List<InterviewQuestion> findByTopicAndOptionalConfidenceLevels(
            @Param("topicId") Long topicId,
            @Param("userId") Long userId,
            @Param("confidenceLevels") List<ConfidenceLevel> confidenceLevels
    );

}
