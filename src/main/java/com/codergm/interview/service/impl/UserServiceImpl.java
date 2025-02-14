package com.codergm.interview.service.impl;

import com.codergm.interview.mapper.UserMapper;
import com.codergm.interview.model.dto.UserDTO;
import com.codergm.interview.model.entity.User;
import com.codergm.interview.model.request.LoginRequest;
import com.codergm.interview.repository.UserRepository;
import com.codergm.interview.service.UserService;
import com.codergm.interview.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {

        if(userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email address already in use");
        }

        User user = userMapper.toEntity(userDTO);

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return jwtUtil.generateToken(user);
    }
}
