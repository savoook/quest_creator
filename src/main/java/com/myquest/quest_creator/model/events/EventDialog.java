package com.myquest.quest_creator.model.events;

import com.myquest.quest_creator.model.Event;
import org.springframework.data.relational.core.mapping.Table;

@Table("event_dialog")
public class EventDialog extends Event {
    String text;
}
