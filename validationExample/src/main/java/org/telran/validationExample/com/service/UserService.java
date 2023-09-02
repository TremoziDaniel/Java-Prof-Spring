package org.telran.validationExample.com.service;

import org.telran.validationExample.com.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(long id);

    User addUser(User user);
}
