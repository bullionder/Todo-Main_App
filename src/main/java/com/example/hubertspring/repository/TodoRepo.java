package com.example.hubertspring.repository;

import com.example.hubertspring.entity.TodoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM todo WHERE user_id = ?userId AND todo_title = ?2 LIMIT 1", nativeQuery = true)
    void deleteByTodoTitleAndUserId(@Param("userId") Long userId, String todoTitle);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM todo WHERE user_id = :userId", nativeQuery = true)
    void deleteAllWithUserId(@Param("userId") Long userId);

    TodoEntity findByTodoTitle(String todoTitle);
}
