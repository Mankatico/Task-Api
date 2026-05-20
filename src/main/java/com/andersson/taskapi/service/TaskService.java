package com.andersson.taskapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersson.taskapi.exception.TaskNotFoundException;
import com.andersson.taskapi.model.Task;
import com.andersson.taskapi.repository.TaskRepository;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  // Get all tasks
  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  // Get tasks by title
  public List<Task> getTaskByTitle(String title) {
    return taskRepository.findByTitleContaining(title);
  }

  // Get a task by ID
  public Task getTaskById(Long id) {
    return taskRepository.findById(id)
        .orElseThrow(() -> new TaskNotFoundException("Tarea no encontrada con ID: " + id));
  }

  // Create a new task
  public Task createTask(Task task) {
    task.setCreateAt(LocalDateTime.now());
    return taskRepository.save(task);
  }

  // Get tasks by completion status
  public List<Task> getTasksByCompleted(Boolean completed) {
    return taskRepository.findByCompleted(completed);
  }

  // Get tasks by title ignoring case
  public List<Task> getTasksByTitleIgnoreCase(String title) {
    return taskRepository.findByTitleContainingIgnoreCase(title);
  }

  // Update an existing task
  public Task updateTask(Long id, Task taskDetails) {
    Task task = getTaskById(id);
    task.setTitle(taskDetails.getTitle());
    task.setCompleted(taskDetails.getCompleted());
    return taskRepository.save(task);
  }

  // Delete a task
  public void deleteTask(Long id) {
    Task task = getTaskById(id);
    taskRepository.delete(task);
  }

}
