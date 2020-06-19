package br.com.wfincatti.userapi.gateway.assembler;

import br.com.wfincatti.userapi.domain.entity.User;
import br.com.wfincatti.userapi.gateway.rest.UserController;
import br.com.wfincatti.userapi.gateway.assembler.dto.UserModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<User, UserModel> {

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(User entity) {

        UserModel userModel = instantiateModel(entity);

        userModel.add(linkTo(
                methodOn(UserController.class)
                        .findUser(entity.getId()))
                .withSelfRel());

        userModel.setId(entity.getId());
        userModel.setName(entity.getName());
        userModel.setLastName(entity.getLastName());

        return userModel;
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserModel> userModels = super.toCollectionModel(entities);

        userModels.add(linkTo(methodOn(UserController.class).findAllUsers()).withSelfRel());

        return userModels;
    }
}
