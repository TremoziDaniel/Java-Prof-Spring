package org.telran.validationExample.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.validationExample.com.entity.Account;

@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    private AccountService accountService;


    @Override
    public void transfer(long id1, long id2, int amount) {
        Account acc1 = accountService.getById(id1);
        if(acc1.getAmount() - amount < 0) {
            throw new IllegalArgumentException("Not enough amount on account 1");
        }

        acc1.setAmount(acc1.getAmount() - amount);
        accountService.save(acc1);

        Account acc2 = accountService.getById(id2);
        acc2.setAmount(acc2.getAmount() + amount);
        accountService.save(acc2);
    }
}
