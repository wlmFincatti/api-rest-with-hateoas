package br.com.wfincatti.userapi.domain.port;

import br.com.wfincatti.userapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "UPDATE User user SET user.name =:name, user.last_name =:last_name, user.password =:password WHERE user.id =:id")
    void updateUser(@Param("id") Integer id, @Param("name") String name, @Param("last_name") String lastName, @Param("password") String password);
}
