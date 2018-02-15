package main.deft.accounter;

import main.deft.dataBase.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Optional<User> getUser(String login, String password) {
        if (loginToProfile.isEmpty()) {
            return getUserFromDB(login, password);
        }
        return loginToProfile.values().stream().filter(v -> login.equals(v.getLogin())).findAny();
    }

    public Optional<User> getUserFromDB(String login, String password) {
        return Optional.ofNullable(userRepository.getUserByLoginEqualsAndPasswordEquals(login, password));
    }
}
