package com.myquest.quest_creator.service;

import com.myquest.quest_creator.controller.request.CreateQuestRequest;
import com.myquest.quest_creator.model.Quest;
import com.myquest.quest_creator.model.Stage;
import com.myquest.quest_creator.repository.QuestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestService {

    private final QuestRepository questRepository;

    public List<Quest> getAll() {

        return questRepository.getAll();
    }

    public List<Quest> findByUserId(Integer userId) {

        return questRepository.findByUserId(userId);
    }

    public Quest create(CreateQuestRequest request) {

        return questRepository.save(Quest.fromCreateRequest(request));
    }

    public List<Stage> findAllStageseById(Integer id) {
        return questRepository.findById(id)
                .map(Quest::getStages)
                .stream()
                .flatMap(Set::stream)
                .toList();
    }
}
