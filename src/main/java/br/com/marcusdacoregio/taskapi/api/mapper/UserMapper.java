package br.com.marcusdacoregio.taskapi.api.mapper;

import br.com.marcusdacoregio.taskapi.api.dto.UserDataDto;
import br.com.marcusdacoregio.taskapi.core.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User userDataDtoToUser(UserDataDto userDataDto) {
        User user = new User();
        user.setUsername(userDataDto.getUsername());
        user.setPassword(userDataDto.getPassword());

        return user;
    }

}
