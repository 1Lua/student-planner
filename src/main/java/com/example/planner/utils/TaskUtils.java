package com.example.planner.utils;

import com.example.planner.dto.TaskStatus;
import com.example.planner.dto.task.CreateTaskDto;
import com.example.planner.dto.task.TaskDto;
import com.example.planner.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskUtils {

    public TaskEntity convertDtoToEntity (TaskDto taskDto) {
        if (taskDto == null) {
             return null;
        }
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(taskDto.getId());
        taskEntity.setName(taskDto.getName());
        taskEntity.setDescription(taskDto.getDescription());
        taskEntity.setCreateDate(taskDto.getCreateDate());
        taskEntity.setDate(taskDto.getDate());
        taskEntity.setStatus(taskDto.getStatus());
        taskEntity.setTaskStatus(TaskStatus.getTaskStatus(taskDto.getName()));
        return taskEntity;
    }

    public TaskDto convertEntityToDto (TaskEntity taskEntity) {
        if (taskEntity == null) {
            return null;
        }
        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskEntity.getId());
        taskDto.setName(taskEntity.getName());
        taskDto.setDescription(taskEntity.getDescription());
        taskDto.setCreateDate(taskEntity.getCreateDate());
        taskDto.setDate(taskEntity.getDate());
        TaskStatus status = taskEntity.getTaskStatus();
        taskDto.setStatus(status != null ? status.getName() : TaskStatus.NONE.getName());
        return taskDto;
    }

    public TaskEntity fillTask(TaskEntity taskEntity, CreateTaskDto createTaskDto) {
        taskEntity.setName(createTaskDto.getName());
        taskEntity.setDescription(createTaskDto.getDescription());
        taskEntity.setCreateDate(new Date());
        taskEntity.setDate(createTaskDto.getDate());
        taskEntity.setStatus(createTaskDto.getStatus());
        taskEntity.setTaskStatus(TaskStatus.getTaskStatus(createTaskDto.getName()));
        return taskEntity;
    }

    public TaskEntity fillTask(TaskEntity taskEntity, TaskDto taskDto) {
        taskEntity.setId(taskDto.getId());
        taskEntity.setName(taskDto.getName());
        taskEntity.setDescription(taskDto.getDescription());
        taskEntity.setCreateDate(new Date());
        taskEntity.setDate(taskDto.getDate());
        taskEntity.setStatus(taskDto.getStatus());
        taskEntity.setTaskStatus(TaskStatus.getTaskStatus(taskDto.getName()));
        return taskEntity;
    }

}
