package org.telran.validationExample.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telran.validationExample.com.converter.UserConverter;
import org.telran.validationExample.com.dto.UserCreateDto;
import org.telran.validationExample.com.dto.UserDto;
import org.telran.validationExample.com.entity.User;
import org.telran.validationExample.com.exception.UserNotFoundException;
import org.telran.validationExample.com.service.UserService;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    //1 trace
    //2 debug<
    //3 info~
    //4 warn~
    //5 error~

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter converter;

    @GetMapping
    List<UserDto> getAll() {

        logger.info("Call method getALl");

        return userService.getAll()
                .stream()
                .map(user -> converter.toDto(user)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    UserDto getById(@PathVariable (name = "id") long id) {

        logger.info("Call method getById with id {}", id);
            return converter.toDto(userService.getById(id));

//        return  converter.toDto(userService.getById(id));
    }

    @PostMapping
    UserDto addUser(@RequestBody UserCreateDto userCreateDto) {
        return converter.toDto(userService.addUser(converter.toEntity(userCreateDto)));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> exceptionHandler(ConstraintViolationException ex) {
        Map<String, String> map = new HashMap<>();
        ex.getConstraintViolations().forEach(error->{
            map.put(error.getPropertyPath().toString(), error.getMessage());
        });

        return map;
    }
}
