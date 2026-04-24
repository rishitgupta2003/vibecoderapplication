package dev.rishit.vibecoder.service.mapper;

import dev.rishit.vibecoder.dto.auth.UserDto;
import dev.rishit.vibecoder.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
}