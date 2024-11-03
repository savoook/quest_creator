package com.myquest.quest_creator.controller.request;

import lombok.NonNull;

public record CreateUserRequest(
        @NonNull
        String login,
        @NonNull
        String pass,
        Integer mode,
        @NonNull
        String email,
        Integer prefLang) {
}

