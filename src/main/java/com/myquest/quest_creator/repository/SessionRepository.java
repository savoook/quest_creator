package com.myquest.quest_creator.repository;

import com.myquest.quest_creator.model.Session;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends Repository<Session, Integer> {

    @Query("select * from sess where user_id = :userId")
    List<Session> getAllByUserId(Integer userId);

    Optional<Session> findById(Integer id);

    @Query("SELECT user_id FROM sess WHERE id = :sessionId")
    Optional<Integer> findUserIdBySessionId(Integer sessionId);
}
