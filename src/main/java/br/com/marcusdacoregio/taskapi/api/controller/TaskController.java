package br.com.marcusdacoregio.taskapi.api.controller;

import br.com.marcusdacoregio.taskapi.api.dto.TaskDto;
import br.com.marcusdacoregio.taskapi.core.enums.TaskStatus;
import br.com.marcusdacoregio.taskapi.core.filter.QueryPaging;
import br.com.marcusdacoregio.taskapi.core.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskDto save(@RequestBody @Valid TaskDto taskDto) {
        return taskService.save(taskDto);
    }

    @DeleteMapping("/{taskId}")
    public void delete(@PathVariable Long taskId) {
        taskService.delete(taskId);
    }

    @PutMapping("/{taskId}/status")
    public TaskDto updateStatus(@PathVariable Long taskId, @RequestParam @NotNull TaskStatus newTaskStatus) {
        return taskService.updateStatus(taskId, newTaskStatus);
    }

    @GetMapping("/{taskId}")
    public TaskDto find(@PathVariable Long taskId) {
        return taskService.find(taskId);
    }

    @GetMapping
    public Page<TaskDto> findAll(QueryPaging queryPaging) {
        return taskService.findAll(queryPaging);
    }

}
