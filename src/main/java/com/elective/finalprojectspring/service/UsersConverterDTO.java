package com.elective.finalprojectspring.service;

import com.elective.finalprojectspring.dto.UserDTO;
import com.elective.finalprojectspring.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UsersConverterDTO {
    public User fromUserDtoToUser(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getSurname(),
                userDTO.getEmail(), userDTO.getPassword(), userDTO.getRoleUser());
    }

    public UserDTO fromUserToUserDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .roleUser(user.getRoleUser())
                .build();
    }
}