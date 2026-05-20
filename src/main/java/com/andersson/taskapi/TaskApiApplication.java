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
			// Crear tareas con títulos variados
			taskService.createTask(new Task("Estudiar Java", "Curso Spring", false));
			taskService.createTask(new Task("estudiar Docker", "Contenedores", false));
			taskService.createTask(new Task("Hacer deporte", "Correr", true));

			System.out.println("=== Buscando 'estudiar' (ignora mayúsculas) ===");
			taskService.getTasksByTitleIgnoreCase("EsTuDIar")
					.forEach(t -> System.out.println(t.getTitle() + " - " + t.getCompleted()));
		};
	}

}
