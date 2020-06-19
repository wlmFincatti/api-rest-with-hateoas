package br.com.wfincatti.userapi.gateway.rest;

import br.com.wfincatti.userapi.domain.entity.User;
import br.com.wfincatti.userapi.gateway.assembler.UserAssembler;
import br.com.wfincatti.userapi.gateway.assembler.dto.UserModel;
import br.com.wfincatti.userapi.gateway.converter.UserToEntity;
import br.com.wfincatti.userapi.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private FindUser findUser;
    private CreateUser createUser;
    private UserAssembler userAssembler;
    private DeleteUser deleteUser;
    private ListUsers listUsers;
    private EditUser editUser;

    @Autowired
    public UserController(FindUser findUser, CreateUser createUser, UserAssembler userAssembler, DeleteUser deleteUser, ListUsers listUsers, EditUser editUser) {
        this.findUser = findUser;
        this.createUser = createUser;
        this.userAssembler = userAssembler;
        this.deleteUser = deleteUser;
        this.listUsers = listUsers;
        this.editUser = editUser;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> findUser(@PathVariable Integer id) {
        User userFound = findUser.execute(id);
        return ResponseEntity.ok(userAssembler.toModel(userFound));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<UserModel>> findAllUsers() {
        List<User> execute = listUsers.execute();
        CollectionModel<UserModel> userModels = userAssembler.toCollectionModel(execute);
        return ResponseEntity.ok(userModels);
    }

    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody UserToEntity user) {
        User userSaved = createUser.execute(UserToEntity.convert(user));
        final URI uri =
                MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(userSaved.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(userAssembler.toModel(userSaved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Integer id, @RequestBody UserToEntity user) {
        editUser.execute(id, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeUser(@PathVariable Integer id) {
        deleteUser.execute(id);
        return ResponseEntity.noContent().build();
    }
}
