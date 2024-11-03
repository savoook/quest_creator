package com.myquest.quest_creator.model;

import com.myquest.quest_creator.controller.request.CreateUserRequest;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    private String login;
    private String pass;
    private Integer mode;
    private String email;
    private Integer prefLang;

    public static User fromCreateRequest(CreateUserRequest request) {
        return User.builder()
                .login(request.login())
                .pass(request.pass())
                .mode(request.mode())
                .email(request.email())
                .prefLang(request.prefLang())
                .build();
    }
}
