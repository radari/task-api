package br.com.marcusdacoregio.taskapi.core.service;

import br.com.marcusdacoregio.taskapi.core.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    public String signin(String username, String password);

    public String signup(User user);

    public User search(String username);

    public User whoami(HttpServletRequest req);

}
