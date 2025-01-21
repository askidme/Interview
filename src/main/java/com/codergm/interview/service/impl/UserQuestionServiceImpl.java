package com.codergm.interview.service.impl;

import com.codergm.interview.mapper.UserQuestionMapper;
import com.codergm.interview.model.dto.UserQuestionDTO;
import com.codergm.interview.model.entity.UserQuestion;
import com.codergm.interview.model.entity.UserQuestionId;
import com.codergm.interview.repository.InterviewQuestionRepository;
import com.codergm.interview.repository.UserQuestionRepository;
import com.codergm.interview.repository.UserRepository;
import com.codergm.interview.service.UserQuestionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserQuestionServiceImpl implements UserQuestionService {
    private final UserQuestionRepository userQuestionRepository;
    private final UserRepository userRepository;
    private final InterviewQuestionRepository questionRepository;
    private final UserQuestionMapper userQuestionMapper;

    @Override
    @Transactional
    public UserQuestionDTO saveUserQuestion(UserQuestionDTO dto) {

        UserQuestion userQuestion = userQuestionMapper.toEntity(dto);

        userQuestion.setId(new UserQuestionId(dto.getUserId(), dto.getQuestionId()));

        return userQuestionMapper.toDto(userQuestionRepository.save(userQuestion));
    }
}
