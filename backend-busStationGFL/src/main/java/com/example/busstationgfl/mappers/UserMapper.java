package com.example.busstationgfl.mappers;

import com.example.busstationgfl.dtos.requests.RegisterRequest;
import com.example.busstationgfl.dtos.user.UserDto;
import com.example.busstationgfl.entities.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User registerRequestToUser(RegisterRequest registerRequest);

    UserDto userToUserDto(User user);
}


