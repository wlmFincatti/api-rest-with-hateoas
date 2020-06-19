package br.com.wfincatti.userapi.usecase;

import br.com.wfincatti.userapi.domain.entity.User;
import br.com.wfincatti.userapi.domain.port.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {

    @Autowired
    private UserRepository userRepository;

    public User execute(User user) {
        return userRepository.save(user);
    }
}
