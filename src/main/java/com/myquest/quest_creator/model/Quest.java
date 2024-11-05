package com.myquest.quest_creator.model;

import com.myquest.quest_creator.controller.request.CreateQuestRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table(name = "quest")
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quest {
    @Id
    Integer id;
    Integer userId;
    String name;
    String image;
    @Builder.Default
    Integer defaultStage = 1;
    @MappedCollection(idColumn = "quest_id")
    Set<QuestLang> langs;
    @MappedCollection(idColumn = "quest_id")
    Set<Stage> stages;
    Integer defaultLang;

    public static Quest fromCreateRequest(CreateQuestRequest request) {
        return Quest.builder()
                .userId(request.userId())
                .name(request.name())
                .image(request.image())
                .defaultStage(request.defaultStage())
                .defaultLang(request.defaultLang())
                .build();
    }
}
