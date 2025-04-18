package com.group.libraryapp.service;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request) {
        if(userRepository.findByName(request.getName()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User u = userRepository.save(new User(request.getName(), request.getAge()));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new) // .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
//        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name) {
        // SELECT * FROM
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
//        if(user == null) {
//            throw new IllegalArgumentException();
//        }

//        if(!userRepository.existsByName(user.getName())) {
//            throw new IllegalArgumentException();
//        }

        userRepository.delete(user);
    }
}