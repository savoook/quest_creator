package com.myquest.quest_creator.repository;

import com.myquest.quest_creator.model.Stage;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StageRepository extends Repository<Stage, Integer> {

    Stage save(Stage stage);

    @Query("select * from stage s")
    List<Stage> getAll();
}
