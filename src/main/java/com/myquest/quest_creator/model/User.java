package com.myquest.quest_creator.model;

import com.myquest.quest_creator.controller.request.CreateUserRequest;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "user")
@Getter
@Builder
public class User {
    @Id
    private Integer id;
    private String login;
    private String pass;
    private Integer mode;
    private String email;
    private Integer prefLang;
    @MappedCollection(idColumn = "user_id")
    private Quest quest;

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
