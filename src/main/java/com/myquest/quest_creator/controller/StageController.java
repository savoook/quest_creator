package com.myquest.quest_creator.controller;

import com.myquest.quest_creator.controller.request.CreateStageRequest;
import com.myquest.quest_creator.model.Stage;
import com.myquest.quest_creator.service.StageService;
import com.myquest.quest_creator.utils.DataResult;
import com.myquest.quest_creator.utils.HttpUtils;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stages")
public class StageController {

    private final StageService stageService;

    @GetMapping
    @Operation(summary = "Получить все стейджи")
    public ResponseEntity<DataResult<List<Stage>>> getAll() {
        return HttpUtils.ok(stageService.getAll());
    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Создать стейдж")
    public ResponseEntity<DataResult<Stage>> create(@RequestBody CreateStageRequest request) {

        return HttpUtils.ok(stageService.create(request));
    }
}
