package org.telran.validationExample.com.converter;

import org.telran.validationExample.com.dto.UserCreateDto;
import org.telran.validationExample.com.dto.UserDto;
import org.telran.validationExample.com.entity.User;

public interface UserConverter {
//public interface UserConverter<T, K> { T toDto(K user);}

    UserDto toDto(User user);

    User toEntity(UserCreateDto userDto);
}
