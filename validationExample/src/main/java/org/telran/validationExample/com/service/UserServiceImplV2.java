package org.telran.validationExample.com.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.telran.validationExample.com.entity.User;

import java.util.List;

//@Service
//@Profile("dev")
public class UserServiceImplV2 implements UserService{
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(long id) {return null;}

    @Override
    public User addUser(User user) {
        return null;
    }
}
