package org.telran.validationExample.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.validationExample.com.controller.UserController;
import org.telran.validationExample.com.entity.User;
import org.telran.validationExample.com.exception.UserNotFoundException;
import org.telran.validationExample.com.repository.UserRepository;


import java.util.List;

@Service
//@Profile("prod")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(long id) {
        User user = repository.findById(id).orElse(null);
        if(user == null) {
            throw new UserNotFoundException(String.format("Client with id %d not found",
                    id));
        }

        return repository.getReferenceById(id);
//        if (id < 0) {
//            logger.error("Incorrect id {}", id);
//            return null;
//        }
//        try {
//            return repository.getReferenceById(id);
//        } catch (Exception exception) {
//            throw new IllegalArgumentException("User with id " + id + " not found.");
//        }
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }
}
