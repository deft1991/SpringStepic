package main.deft.accounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountService {
   private final Map<String,User> loginToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
    }

    public Map<String, User> getLoginToProfile() {
        return loginToProfile;
    }

    public void addNewUser(User newUser){
        loginToProfile.put(newUser.getLogin(),newUser);
    }

    public User getUserByLogin(String login){
        return loginToProfile.get(login);
    }
}
