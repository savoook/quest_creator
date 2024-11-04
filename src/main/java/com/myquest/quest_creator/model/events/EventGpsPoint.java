package com.myquest.quest_creator.model.events;

import com.myquest.quest_creator.model.Event;
import org.springframework.data.relational.core.mapping.Table;

@Table("event_gps_point")
public class EventGpsPoint extends Event {
    Double lat;
    Double lon;
    Integer radius;
    Integer reachStage;

}
