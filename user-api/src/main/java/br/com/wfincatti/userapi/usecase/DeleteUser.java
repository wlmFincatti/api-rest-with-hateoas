package br.com.wfincatti.userapi.usecase;

import br.com.wfincatti.userapi.domain.entity.User;
import br.com.wfincatti.userapi.domain.exception.UserNotFoundException;
import br.com.wfincatti.userapi.domain.port.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUser {

    @Autowired
    private UserRepository userRepository;

    public void execute(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(String.format("user Not found to delete with id %d ", id));
        }
        userRepository.deleteById(id);
    }
}
