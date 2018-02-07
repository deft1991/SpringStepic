package controller;

import accounter.AccountService;
import accounter.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpServlet {
    AccountService accountService = new AccountService();

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ResponseEntity getMovie(@RequestParam String login, @RequestParam String pass) {
        accountService.getUsers().add(new User(login, pass));
//        model.addAttribute("login", login);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
