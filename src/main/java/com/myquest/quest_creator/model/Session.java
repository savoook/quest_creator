package com.myquest.quest_creator.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "sess")
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Session {
    @Id
    Integer id;
    String secret;
    LocalDateTime startTime;
}
