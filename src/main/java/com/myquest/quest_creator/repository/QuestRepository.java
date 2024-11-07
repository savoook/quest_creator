package com.myquest.quest_creator.repository;

import com.myquest.quest_creator.model.Quest;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface QuestRepository extends Repository<Quest, Integer> {

    Quest save(Quest quest);

    @Query("select * from quest")
    List<Quest> getAll();

    Optional<Quest> findById(Integer id);

    @Query("select * from quest where user_id = :userId")
    List<Quest> findByUserId(Integer userId);
}
