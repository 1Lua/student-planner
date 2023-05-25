package com.example.planner.controllers;

import com.example.planner.dto.task.CreateTaskDto;
import com.example.planner.dto.task.TaskDto;
import com.example.planner.service.TaskService;
import com.example.planner.utils.TaskUtils;
import com.example.planner.validators.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskUtils taskUtils;

    @Autowired
    TaskValidator taskValidator;

    @PostMapping("/create")
    public TaskDto createTask(@RequestBody CreateTaskDto createTaskDto) {
        taskValidator.validateCreateTaskDto(createTaskDto);
        return taskUtils.convertEntityToDto(taskService.createTask(createTaskDto));
    }

    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable String id) {
        return taskUtils.convertEntityToDto(taskService.getTask(id));
    }

    @PostMapping("/edit")
    public TaskDto editTask(@RequestBody TaskDto taskDto) {
        taskValidator.validateEditTaskDto(taskDto);
        return taskUtils.convertEntityToDto(taskService.editTask(taskDto));
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }
}
