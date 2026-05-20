package com.andersson.taskapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.andersson.taskapi.model.Task;
import com.andersson.taskapi.service.TaskService;

@SpringBootApplication
public class TaskApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(TaskService taskService) {
		return args -> {
			// Crear una tarea de prueba
			Task tarea = new Task("Mi primera tarea", false);
			Task guardada = taskService.createTask(tarea);
			System.out.println("Tarea guardada con ID: " + guardada.getId());

			// Listar todas las tareas
			System.out.println("Total de tareas: " + taskService.getAllTasks().size());
		};
	}

}
