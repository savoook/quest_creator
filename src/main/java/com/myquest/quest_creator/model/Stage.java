package com.myquest.quest_creator.model;

import com.myquest.quest_creator.controller.request.CreateStageRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "stage")
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stage {
    @Id
    Integer id;

    public static Stage fromCreateRequest(CreateStageRequest request) {
        return Stage.builder()
                .build();
    }
}
