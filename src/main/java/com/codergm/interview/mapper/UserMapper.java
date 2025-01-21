package com.codergm.interview.mapper;

import com.codergm.interview.annotation.PasswordEncoder;
import com.codergm.interview.model.dto.UserDTO;
import com.codergm.interview.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userQuestions", ignore = true)
    @Mapping(target = "password", source = "password", qualifiedBy = PasswordEncoder.class)
    User toEntity(UserDTO user);

    @Mapping(target = "password", ignore = true)
    UserDTO toDto(User user);

    @PasswordEncoder
    default String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
