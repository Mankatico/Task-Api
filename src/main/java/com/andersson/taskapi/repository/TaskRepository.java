package com.andersson.taskapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersson.taskapi.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByTitleContaining(String title);

  List<Task> findByCompleted(Boolean completed);

  List<Task> findByTitleContainingIgnoreCase(String title);
}
