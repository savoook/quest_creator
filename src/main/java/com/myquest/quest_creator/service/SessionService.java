package com.myquest.quest_creator.service;

import com.myquest.quest_creator.model.Session;
import com.myquest.quest_creator.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionService {

    private final SessionRepository sessionRepository;

    public Session findById(Integer id) {

        return sessionRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("сессия с таким id %d не найден", id)));
    }
}
