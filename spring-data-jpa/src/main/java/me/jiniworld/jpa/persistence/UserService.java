package me.jiniworld.jpa.persistence;

import lombok.RequiredArgsConstructor;
import me.jiniworld.jpa.domain.projection.UserSummary;
import me.jiniworld.jpa.domain.projection.UsernameOnly;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserSummary selectSummary(long id) {
        return userRepository.getById(id, UserSummary.class).orElse(null);
    }

    public UsernameOnly selectUsername(long id) {
        return userRepository.getById(id, UsernameOnly.class).orElse(null);
    }
}
