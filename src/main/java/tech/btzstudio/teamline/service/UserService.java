package tech.btzstudio.teamline.service;

import org.springframework.stereotype.Service;
import tech.btzstudio.teamline.domain.User;
import tech.btzstudio.teamline.domain.repository.UserRepository;
import tech.btzstudio.teamline.model.dto.UserCreationRequest;
import tech.btzstudio.teamline.model.mapper.UserMapper;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService (UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User create (UserCreationRequest request) {
        final User user = userMapper.toUser(request);
        return userRepository.save(user);
    }

    public Optional<User> find (Long userId) {
        return userRepository.findById(userId);
    }
}
