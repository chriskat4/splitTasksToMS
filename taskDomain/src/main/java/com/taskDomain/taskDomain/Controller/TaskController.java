package com.taskDomain.taskDomain.Controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskDomain.taskDomain.Dto.TaskDto;
import com.taskDomain.taskDomain.Dto.TaskUpdateRequest;
import com.taskDomain.taskDomain.Model.TaskModel;
import com.taskDomain.taskDomain.Service.TaskService;



@RestController
@RequestMapping("/Task/Tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

   

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<TaskModel>>> getAllTaskByUserId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskByUserId(id));
    }
    
    @PostMapping
    public ResponseEntity<String> saveTask(@RequestBody TaskDto taskDto){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.saveTasks(taskDto));
    }

     @PutMapping("/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable UUID id,@RequestBody TaskUpdateRequest taskUpdateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.updateTask(id, taskUpdateRequest));
    }


}
