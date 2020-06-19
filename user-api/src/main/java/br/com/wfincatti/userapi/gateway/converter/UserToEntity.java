package br.com.wfincatti.userapi.gateway.converter;

import br.com.wfincatti.userapi.domain.entity.User;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserToEntity {

    private String name;
    private String lastName;
    private String password;

    public static User convert(UserToEntity user) {
        return User
                .builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
    }
}
