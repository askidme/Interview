package com.codergm.interview.controller;

import com.codergm.interview.model.dto.UserQuestionDTO;
import com.codergm.interview.service.UserQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/user-questions")
public class UserQuestionController {

    private final UserQuestionService userQuestionService;

    public UserQuestionController(UserQuestionService userQuestionService) {
        this.userQuestionService = userQuestionService;
    }

    @PostMapping
    public ResponseEntity<UserQuestionDTO> createUserQuestion(@RequestBody UserQuestionDTO dto) {
        UserQuestionDTO savedDto = userQuestionService.saveUserQuestion(dto);
        return ok(savedDto);
    }
}

