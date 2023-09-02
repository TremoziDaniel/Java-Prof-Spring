package org.telran.validationExample.com.service;

import org.telran.validationExample.com.entity.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);

    Account getById(long id);

    List<Account> getAll();
}
