package main.deft.dataBase;

import main.deft.accounter.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by s.golitsyn on 13.02.2018
 */


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User,Long> {
}
