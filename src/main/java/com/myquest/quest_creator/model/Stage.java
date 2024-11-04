package com.myquest.quest_creator.model;

import com.myquest.quest_creator.controller.request.CreateStageRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "stage")
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stage {
    @Id
    Integer id;
    @Column("quest_id")
    Integer questId;

    public static Stage fromCreateRequest(CreateStageRequest request) {
        return Stage.builder()
                .questId(request.questId())
                .build();
    }
}
