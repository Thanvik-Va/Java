package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
