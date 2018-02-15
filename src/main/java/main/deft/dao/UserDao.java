package main.deft.dao;

import main.deft.accounter.User;

public interface UserDao {
    public void createUser(User user);
    public void updateUser(Long id, User user);
    public void deleteUser(User user);
    public User getUserByLogin(String login);
    public User getUserById(long id);
}
