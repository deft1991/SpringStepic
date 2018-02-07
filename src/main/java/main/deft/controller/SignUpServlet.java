package main.deft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import main.deft.accounter.AccountService;
import main.deft.accounter.User;

@Controller
public class SignUpServlet {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity getMovie(@RequestParam String login, @RequestParam String password) {
        accountService.getLoginToProfile().put(login, new User(login, password));
//        model.addAttribute("login", login);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
