package com.taskDomain.taskDomain.Service;


import java.util.List;
import java.util.Optional;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.taskDomain.taskDomain.Dto.TaskDto;
import com.taskDomain.taskDomain.Dto.TaskUpdateRequest;
import com.taskDomain.taskDomain.Model.TaskModel;
import com.taskDomain.taskDomain.Repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<List<TaskModel>> getTaskByUserId(UUID id){
        return Optional.of(taskRepository.findTaskByUserId(id));
    }

    public String saveTasks(TaskDto taskDto){
        
        for(String t: taskDto.tasks().stream().collect(Collectors.toSet())){
            TaskModel task = new TaskModel();
            task.setTask(t);
            task.setUser_Id(taskDto.userID());
            taskRepository.save(task);
        }

        return "Saved";
    }

    public TaskModel updateTask(UUID id, TaskUpdateRequest taskUpdateRequest){

        TaskModel task = new TaskModel();

        task.setId(id);
        task.setTask(taskUpdateRequest.task());
        task.setUser_Id(taskUpdateRequest.userID());

        return task;
    }

}
