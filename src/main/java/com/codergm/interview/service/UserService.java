package com.codergm.interview.service;

import com.codergm.interview.model.dto.UserDTO;
import com.codergm.interview.model.request.LoginRequest;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    String login(LoginRequest request);
}
