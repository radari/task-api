package br.com.marcusdacoregio.taskapi.api.mapper;

import br.com.marcusdacoregio.taskapi.api.dto.TaskDto;
import br.com.marcusdacoregio.taskapi.core.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Task toEntity(TaskDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }

    public TaskDto toDto(Task entity) {
        return modelMapper.map(entity, TaskDto.class);
    }
}
