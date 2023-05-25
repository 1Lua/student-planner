package com.example.planner.service;

import com.example.planner.dto.task.CreateTaskDto;
import com.example.planner.dto.task.TaskDto;
import com.example.planner.entities.TaskEntity;
import com.example.planner.repositories.TaskRepository;
import com.example.planner.utils.TaskUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskUtils taskUtils;

    public TaskEntity createTask(CreateTaskDto createTaskDto) {
        TaskEntity taskEntity = new TaskEntity();
        taskUtils.fillTask(taskEntity, createTaskDto);
        taskRepository.save(taskEntity);
        return taskEntity;
    }

    public TaskEntity getTask(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public TaskEntity editTask(TaskDto taskDto) {
        TaskEntity taskEntity = taskRepository.findById(taskDto.getId()).orElse(null);
        taskUtils.fillTask(taskEntity, taskDto);
        taskRepository.save(taskEntity);
        return taskEntity;
    }
}
