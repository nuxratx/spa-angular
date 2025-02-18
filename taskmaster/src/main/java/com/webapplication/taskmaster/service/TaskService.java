package com.webapplication.taskmaster.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapplication.taskmaster.entity.Task;
import com.webapplication.taskmaster.repository.TaskRepository;


@Service
public class TaskService {
    private final TaskRepository taskRepository;


    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTasksById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
