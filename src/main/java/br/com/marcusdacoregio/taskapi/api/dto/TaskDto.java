package br.com.marcusdacoregio.taskapi.api.dto;

import br.com.marcusdacoregio.taskapi.core.enums.TaskStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class TaskDto {

    private Long id;

    @NotNull(message = "NotNull.TaskDto.title")
    @Size(min = 10, max = 100, message = "Size.TaskDto.title")
    private String title;

    @Size(max = 255, message = "Size.TaskDto.description")
    private String description;

    @NotNull(message = "NotNull.TaskDto.status")
    private TaskStatus status = TaskStatus.NOVA;

    private LocalDateTime creationDate;

    private LocalDateTime conclusionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(LocalDateTime conclusionDate) {
        this.conclusionDate = conclusionDate;
    }
}
