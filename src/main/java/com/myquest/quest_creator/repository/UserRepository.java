package com.myquest.quest_creator.repository;

import com.myquest.quest_creator.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Integer> {

    User save(User user);

    @Query("select * from user")
    List<User> getAll();

    Optional<User> findById(Integer id);
}
