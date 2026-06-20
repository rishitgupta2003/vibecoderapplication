package dev.rishit.vibecoder.mapper;

import dev.rishit.vibecoder.dto.auth.SignupRequest;
import dev.rishit.vibecoder.dto.auth.UserProfileResponse;
import dev.rishit.vibecoder.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);

}
