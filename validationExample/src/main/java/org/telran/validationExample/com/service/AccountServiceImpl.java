package org.telran.validationExample.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.validationExample.com.entity.Account;
import org.telran.validationExample.com.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository repository;

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    public Account getById(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Account> getAll() {
        return repository.findAll();
    }
}
