package com.codergm.interview.controller;

import com.codergm.interview.model.dto.UserDTO;
import com.codergm.interview.model.request.LoginRequest;
import com.codergm.interview.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        try {
            return ok(userService.registerUser(userDTO));
        }catch (IllegalArgumentException e) {
            return badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        try{
            String token = userService.login(loginRequest);
            return ok(Map.of("token", token));
        }catch (IllegalArgumentException e) {
            return  badRequest().body(e.getMessage());
        }
    }
}
