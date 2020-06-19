package br.com.wfincatti.userapi.gateway.assembler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Relation(collectionRelation = "users")
public class UserModel extends RepresentationModel<UserModel> {

    private Integer id;
    private String name;
    private String lastName;

}
