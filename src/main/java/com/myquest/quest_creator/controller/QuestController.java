package com.myquest.quest_creator.controller;

import com.myquest.quest_creator.controller.request.CreateQuestRequest;
import com.myquest.quest_creator.model.Quest;
import com.myquest.quest_creator.model.Stage;
import com.myquest.quest_creator.service.QuestService;
import com.myquest.quest_creator.utils.DataResult;
import com.myquest.quest_creator.utils.HttpUtils;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quests")
@Slf4j
public class QuestController {

    private final QuestService questService;

    @GetMapping
    @Operation(summary = "Получить все квесты")
    public ResponseEntity<DataResult<List<Quest>>> getAll() {

        return HttpUtils.ok(questService.getAll());
    }

    @GetMapping(path = "/user/{userId}")
    @Operation(summary = "Получить все квесты по id юзера")
    public ResponseEntity<DataResult<List<Quest>>> findByUserId(@PathVariable Integer userId) {

        return HttpUtils.ok(questService.findByUserId(userId));
    }

    @GetMapping(path = "/stages/{id}")
    @Operation(summary = "Получить все стейджи по id")
    public ResponseEntity<DataResult<List<Stage>>> findAllStageseById(@PathVariable Integer id) {

        return HttpUtils.ok(questService.findAllStageseById(id));
    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Создать квест")
    public ResponseEntity<DataResult<Quest>> create(@RequestBody CreateQuestRequest request) {

        return HttpUtils.ok(questService.create(request));
    }
}
