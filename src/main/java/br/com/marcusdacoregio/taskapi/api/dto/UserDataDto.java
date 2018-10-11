package br.com.marcusdacoregio.taskapi.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDataDto {

    @NotNull
    @Size(max = 255, min = 8, message = "{Size.UserDataDto.username}")
    private String username;

    @NotNull
    @Size(min = 8,  message = "{Size.UserDataDto.password}")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
