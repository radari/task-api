package br.com.marcusdacoregio.taskapi.core.repository;

import br.com.marcusdacoregio.taskapi.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

}
