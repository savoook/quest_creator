package com.myquest.quest_creator.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "game")
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Game {
    @Id
    Integer id;
    Integer stageId;
    Integer dt;
    Integer lang;
}
