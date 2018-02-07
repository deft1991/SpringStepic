package accounter;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
   static List<User> users = new ArrayList<User>();

    public AccountService() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        users = users;
    }
}
