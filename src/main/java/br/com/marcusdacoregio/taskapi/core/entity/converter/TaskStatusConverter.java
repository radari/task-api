package br.com.marcusdacoregio.taskapi.core.entity.converter;

import br.com.marcusdacoregio.taskapi.core.enums.TaskStatus;

import javax.persistence.AttributeConverter;

public class TaskStatusConverter implements AttributeConverter<TaskStatus, String> {
    @Override
    public String convertToDatabaseColumn(TaskStatus taskStatus) {
        return taskStatus.getCode();
    }

    @Override
    public TaskStatus convertToEntityAttribute(String s) {
        return TaskStatus.fromCode(s);
    }
}
