package br.com.marcusdacoregio.taskapi.core.repository;

import br.com.marcusdacoregio.taskapi.core.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
