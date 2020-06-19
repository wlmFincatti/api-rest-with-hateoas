package br.com.wfincatti.userapi.usecase;

import br.com.wfincatti.userapi.domain.entity.User;
import br.com.wfincatti.userapi.domain.port.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUsers {

    @Autowired
    private UserRepository userRepository;

    public List<User> execute() {
        return userRepository.findAll();
    }

    public Page<User> execute(Pageable page) {
        return userRepository.findAll(page);
    }
}
