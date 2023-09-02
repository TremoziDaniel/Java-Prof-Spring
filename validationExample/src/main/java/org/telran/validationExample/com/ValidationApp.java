package org.telran.validationExample.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
    1. Add field amount to account;
    Add account controller to create account.
    2. Create user and two accounts.
    3. Init account(put money for one or two accounts).
    4. Transfer controller — transfer(user_id, acc1_id, acc2_id, amount).
    5. Transfer service — send amount from one account to another(
    check if amount after transfer on acc1 < 0 — transfer throw exception).
    6. TransactionAspect - log to console start of transfer, result of transfer
    or alert error when exception.
*/

@SpringBootApplication
@EnableScheduling
public class ValidationApp {
    public static void main(String[] args) {
        SpringApplication.run(ValidationApp.class, args);
    }
}
