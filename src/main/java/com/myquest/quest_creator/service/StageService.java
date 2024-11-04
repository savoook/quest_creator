package com.myquest.quest_creator.service;

import com.myquest.quest_creator.controller.request.CreateStageRequest;
import com.myquest.quest_creator.model.Stage;
import com.myquest.quest_creator.repository.StageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StageService {

    private final StageRepository stageRepository;

    public List<Stage> getAll() {
        return stageRepository.getAll();
    }

    public Stage create(CreateStageRequest request) {

        return stageRepository.save(Stage.fromCreateRequest(request));
    }
}
