package com.codergm.interview.repository;

import com.codergm.interview.model.entity.UserQuestion;
import com.codergm.interview.model.entity.UserQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestionRepository extends JpaRepository<UserQuestion, UserQuestionId> {
}
