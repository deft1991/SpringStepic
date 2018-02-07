package main.deft;

import main.deft.accounter.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainConfiguration {

    @Bean
    AccountService accountService(){
        return new AccountService();
    }
}
