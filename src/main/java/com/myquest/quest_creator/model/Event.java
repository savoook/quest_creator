package com.myquest.quest_creator.model;

import com.myquest.quest_creator.model.enums.EventType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "event")
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public abstract class Event {
    @Id
    Integer id;
    EventType type;
}
