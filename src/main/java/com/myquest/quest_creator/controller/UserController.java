package com.myquest.quest_creator.controller;

import com.myquest.quest_creator.controller.request.CreateUserRequest;
import com.myquest.quest_creator.model.User;
import com.myquest.quest_creator.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Получить всех пользователей")
    public ResponseEntity<DataResult<List<User>>> getAll() {
        return HttpUtils.ok(userService.getAll());
    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Создать пользователя")
    public ResponseEntity<DataResult<User>> create(@RequestBody CreateUserRequest request) {

        return HttpUtils.ok(userService.create(request));
    }
}
