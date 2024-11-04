package com.myquest.quest_creator.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "quest_lang")
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestLang {
    @Id
    Integer id;
    @Column("quest_id")
    Integer questId;
    String lang;
    String image;
}
