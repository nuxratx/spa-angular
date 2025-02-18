package com.webapplication.taskmaster.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapplication.taskmaster.entity.Task;
import com.webapplication.taskmaster.service.TaskService;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    private final TaskService taskService; 

    public TaskController(TaskService taskService){
        this.taskService = taskService;

    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = taskService.getTasksById(id);
        if (task.isPresent()){
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping 
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.saveTask(task));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        Optional<Task> taskOptional = taskService.getTasksById(id);
        if (taskOptional.isPresent()){
            Task updatedTask = taskOptional.get();
            updatedTask.setDescription(task.getDescription());
            updatedTask.setDueDate(task.getDueDate());
            updatedTask.setCompleted(task.getCompleted());
            updatedTask.setName(task.getName());
            return ResponseEntity.ok(taskService.saveTask(updatedTask));
        } else {
            return ResponseEntity.notFound().build();
        }
    
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id)
    {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
    


}
  