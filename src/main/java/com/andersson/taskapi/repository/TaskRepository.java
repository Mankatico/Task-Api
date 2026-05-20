package com.andersson.taskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersson.taskapi.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
