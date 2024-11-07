package com.myquest.quest_creator.service;

import com.myquest.quest_creator.controller.request.CreateUserRequest;
import com.myquest.quest_creator.model.User;
import com.myquest.quest_creator.repository.SessionRepository;
import com.myquest.quest_creator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User create(CreateUserRequest request) {

        return userRepository.save(User.fromCreateRequest(request));
    }

    public User findById(Integer id) {

        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("пользователь с таким id {} не найден"));
    }

    public User findBySessionId(Integer id) {
        Integer userId = sessionRepository.findUserIdBySessionId(id).orElseThrow(
                () -> new RuntimeException(String.format("сессия с таким id %d не найден", id)));

        return userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException(String.format("пользователь с таким id %d не найден", userId)));
    }
}
