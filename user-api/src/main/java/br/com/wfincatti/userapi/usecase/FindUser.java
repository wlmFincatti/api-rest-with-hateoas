package br.com.wfincatti.userapi.usecase;

import br.com.wfincatti.userapi.domain.entity.User;
import br.com.wfincatti.userapi.domain.exception.UserNotFoundException;
import br.com.wfincatti.userapi.domain.port.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUser {

    @Autowired
    private UserRepository userRepository;

    public User execute(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("user not found with id %d", id)));
    }
}
