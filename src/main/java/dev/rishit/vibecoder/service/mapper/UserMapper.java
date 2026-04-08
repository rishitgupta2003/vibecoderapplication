package dev.rishit.vibecoder.service.mapper;

import dev.rishit.vibecoder.dto.auth.UserDto;
import dev.rishit.vibecoder.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }
}