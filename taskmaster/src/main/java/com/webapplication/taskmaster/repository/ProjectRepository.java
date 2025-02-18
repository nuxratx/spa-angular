package com.webapplication.taskmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapplication.taskmaster.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{


}
