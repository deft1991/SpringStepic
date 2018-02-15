package main.deft.dataBase;

import main.deft.accounter.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by s.golitsyn on 13.02.2018
 */


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update User user set user.password =:password, user.login =:login where user.id =:id")
    void updatePassword(@Param("id") Long id, @Param("password") String password, @Param("login") String login);

    @Transactional
//    @Modifying(clearAutomatically = true)
    User getUserByLoginEqualsAndPasswordEquals(@Param("login") String login, @Param("password") String password);
}
