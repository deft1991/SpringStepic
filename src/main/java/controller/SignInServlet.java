package controller;

import accounter.AccountService;
import accounter.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Controller
public class SignInServlet {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity signIn(@RequestParam final String login, @RequestParam String pass) throws ServiceException {
        AccountService accountService = new AccountService();
        Optional<User> any = accountService
                .getUsers()
                .stream()
                .filter(user -> user.getLogin().equals(login) && user.getPass().equals(pass))
                .findAny();
        return any.<ResponseEntity>map(user -> new ResponseEntity<>("Authorized:" + user.getLogin(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Unauthorized", HttpStatus.NOT_FOUND));
    }
}
