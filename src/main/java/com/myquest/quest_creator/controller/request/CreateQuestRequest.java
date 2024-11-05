package com.myquest.quest_creator.controller.request;

import com.myquest.quest_creator.model.QuestLang;

import java.util.Set;

public record CreateQuestRequest(
        Integer userId,
        String name,
        String image,
        Integer defaultStage,
        Set<QuestLang> langs,
        Integer defaultLang
) {
}
