package main.deft.accounter;

import main.deft.dataBase.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountService {
    @Autowired
    UserRepository userRepository;

    private final Map<String, User> loginToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
    }

    public Map<String, User> getLoginToProfile() {
        return loginToProfile;
    }

    public void addNewUser(User newUser) {
        getLoginToProfile().put(newUser.getLogin(), newUser);
        userRepository.save(newUser);
    }

    public User getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
