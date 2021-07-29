package tech.btzstudio.teamline.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import tech.btzstudio.teamline.domain.User;
import tech.btzstudio.teamline.model.dto.UserCreationRequest;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping (target = "firstName", source = "firstName")
    @Mapping (target = "lastName", source = "lastName")
    public User toUser(UserCreationRequest request);

    @Mapping (target = "firstName", source = "firstName")
    @Mapping (target = "lastName", source = "lastName")
    public UserCreationRequest toModel(User user);
}
