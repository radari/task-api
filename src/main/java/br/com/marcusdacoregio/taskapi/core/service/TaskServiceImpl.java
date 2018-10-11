package br.com.marcusdacoregio.taskapi.core.service;

import br.com.marcusdacoregio.taskapi.api.dto.TaskDto;
import br.com.marcusdacoregio.taskapi.api.exception.NotFoundException;
import br.com.marcusdacoregio.taskapi.api.mapper.TaskMapper;
import br.com.marcusdacoregio.taskapi.core.entity.Task;
import br.com.marcusdacoregio.taskapi.core.enums.TaskStatus;
import br.com.marcusdacoregio.taskapi.core.filter.QueryPaging;
import br.com.marcusdacoregio.taskapi.core.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(
            TaskRepository taskRepository,
            TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        Task entity = taskMapper.toEntity(taskDto);
        entity.setCreationDate(LocalDateTime.now());
        return taskMapper.toDto(taskRepository.save(entity));
    }

    @Override
    public void delete(Long taskId) {
        Task task = findEntity(taskId);

        if (task != null) {
            this.taskRepository.delete(task);
        }
    }

    private Task findEntity(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (!task.isPresent()) {
            throw new NotFoundException();
        }
        return task.get();
    }

    @Override
    public TaskDto updateStatus(Long taskId, TaskStatus newTaskStatus) {
        Task task = findEntity(taskId);
        task.setStatus(newTaskStatus);

        task = taskRepository.save(task);

        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto find(Long taskId) {
        Task task = findEntity(taskId);
        return taskMapper.toDto(task);
    }

    @Override
    public Page<TaskDto> findAll(QueryPaging queryPaging) {
        PageRequest pageRequest = PageRequest.of(queryPaging.getPage(), queryPaging.getSize(), Sort.by(Sort.Direction.DESC, "creationDate"));

        return taskRepository.findAll(pageRequest).map(task -> taskMapper.toDto(task));
    }

}
