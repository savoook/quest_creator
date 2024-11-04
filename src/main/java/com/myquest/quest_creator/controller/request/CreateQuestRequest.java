package com.myquest.quest_creator.controller.request;

import com.myquest.quest_creator.model.QuestLang;

import java.util.List;

public record CreateQuestRequest(
        Integer userId,
        String name,
        String image,
        Integer defaultStage,
        List<QuestLang> langs,
        Integer defaultLang
) {
}
