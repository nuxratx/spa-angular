package com.webapplication.taskmaster.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webapplication.taskmaster.entity.Task;

public interface TaskRepository extends  JpaRepository<Task, Long>{ 
}



