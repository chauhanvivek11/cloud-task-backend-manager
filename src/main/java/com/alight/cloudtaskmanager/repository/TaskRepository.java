package com.alight.cloudtaskmanager.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alight.cloudtaskmanager.model.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> { }