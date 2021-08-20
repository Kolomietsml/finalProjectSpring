package com.elective.finalprojectspring.service;

import com.elective.finalprojectspring.dto.UserDTO;
import com.elective.finalprojectspring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UsersConverterDTO usersConverterDTO;
    private UserRepository userRepository;

    @Autowired
    public UserService(UsersConverterDTO usersConverterDTO, UserRepository userRepository) {
        this.usersConverterDTO = usersConverterDTO;
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> save(UserDTO userDTO) {
        return Optional.of(usersConverterDTO.fromUserToUserDto(userRepository.save(usersConverterDTO.fromUserDtoToUser(userDTO))));
    }

    public void delete(long userID) {
        userRepository.deleteById(userID);
    }

    public Optional<UserDTO> findByName(String name) {
        return Optional.of(usersConverterDTO.fromUserToUserDto(userRepository.findByUserName(name).get()));
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(usersConverterDTO::fromUserToUserDto).collect(Collectors.toList());
    }
}
