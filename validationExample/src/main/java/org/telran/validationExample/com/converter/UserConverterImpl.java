package org.telran.validationExample.com.converter;

import org.springframework.stereotype.Component;
import org.telran.validationExample.com.dto.UserCreateDto;
import org.telran.validationExample.com.dto.UserDto;
import org.telran.validationExample.com.entity.User;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getName(), user.getEmail());
    }

    @Override
    public User toEntity(UserCreateDto userDto) {
        return new User(userDto.getName(), userDto.getEmail());
    }
}