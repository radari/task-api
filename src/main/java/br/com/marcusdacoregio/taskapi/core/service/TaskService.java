package br.com.marcusdacoregio.taskapi.core.service;

import br.com.marcusdacoregio.taskapi.api.dto.TaskDto;
import br.com.marcusdacoregio.taskapi.core.enums.TaskStatus;
import br.com.marcusdacoregio.taskapi.core.filter.QueryPaging;
import org.springframework.data.domain.Page;

public interface TaskService {

    TaskDto save(TaskDto taskDto);

    void delete(Long taskId);

    TaskDto updateStatus(Long taskId, TaskStatus newTaskStatus);

    TaskDto find(Long taskId);

    Page<TaskDto> findAll(QueryPaging queryPaging);
}
