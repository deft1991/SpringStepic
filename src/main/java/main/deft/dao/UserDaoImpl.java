package main.deft.dao;

import main.deft.accounter.User;
import main.deft.dataBase.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDaoImpl implements UserDao {


    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        userRepository.updatePassword(id, user.getPassword(), user.getLogin());
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findOne(id);
    }
}
