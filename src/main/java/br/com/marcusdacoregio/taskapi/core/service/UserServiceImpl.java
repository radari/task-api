package br.com.marcusdacoregio.taskapi.core.service;

import br.com.marcusdacoregio.taskapi.api.exception.RestException;
import br.com.marcusdacoregio.taskapi.api.i18n.Message;
import br.com.marcusdacoregio.taskapi.api.security.JwtTokenProvider;
import br.com.marcusdacoregio.taskapi.core.entity.Role;
import br.com.marcusdacoregio.taskapi.core.entity.User;
import br.com.marcusdacoregio.taskapi.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new RestException(Message.VALIDATION_WRONG_CREDENTIALS.getKey());
        }
    }

    @Transactional
    public String signup(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singletonList(Role.ROLE_USER));

            User savedUser = userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), savedUser.getRoles());
        } else {
            throw new RestException(Message.VALIDATION_USER_ALREADY_TAKEN.getKey(), user.getUsername());
        }
    }

    public User search(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RestException(Message.VALIDATION_USER_INEXISTENT.getKey());
        }
        return user;
    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

}
