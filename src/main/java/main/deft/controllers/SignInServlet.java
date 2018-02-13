package main.deft.controllers;

import main.deft.dataBase.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import main.deft.accounter.AccountService;
import main.deft.accounter.User;

import java.util.Optional;

@RestController
public class SignInServlet {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity signIn(@RequestParam final String login, @RequestParam String password) throws ServiceException {
        Optional<User> any = accountService
                .getAllUsers()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findAny();
        return any.<ResponseEntity>map(user -> new ResponseEntity<>("Authorized: " + user.getLogin(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Unauthorized", HttpStatus.NOT_FOUND));
    }
}
