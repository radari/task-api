package br.com.marcusdacoregio.taskapi.api.controller;

import br.com.marcusdacoregio.taskapi.api.dto.UserDataDto;
import br.com.marcusdacoregio.taskapi.api.dto.UserResponseDto;
import br.com.marcusdacoregio.taskapi.api.mapper.UserMapper;
import br.com.marcusdacoregio.taskapi.core.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class AuthenticationController {

    private final UserServiceImpl userService;

    private final ModelMapper modelMapper;

    private final UserMapper userMapper;

    @Autowired
    public AuthenticationController(
            UserServiceImpl userService,
            ModelMapper modelMapper,
            UserMapper userMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userMapper = userMapper;
    }

    @PostMapping("/authenticate")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        return userService.signin(username, password);
    }

    @PostMapping("/register")
    public String signup(@RequestBody @Valid UserDataDto user) {
        return userService.signup(userMapper.userDataDtoToUser(user));
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserResponseDto whoami(HttpServletRequest req) {
        return modelMapper.map(userService.whoami(req), UserResponseDto.class);
    }

}
