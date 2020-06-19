package br.com.wfincatti.userapi.usecase;

import br.com.wfincatti.userapi.domain.entity.User;
import br.com.wfincatti.userapi.domain.exception.UserNotFoundException;
import br.com.wfincatti.userapi.domain.port.UserRepository;
import br.com.wfincatti.userapi.gateway.converter.UserToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditUser {

    @Autowired
    private UserRepository userRepository;

    public void execute(Integer id, UserToEntity user) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(String.format("user not found to update with id %d", id));
        }
        userRepository.updateUser(id, user.getName(), user.getLastName(), user.getPassword());
    }
}
