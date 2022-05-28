package team7.capstone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team7.capstone.domain.LoginVO;
import team7.capstone.domain.UserVO;
import team7.capstone.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public UserVO login(LoginVO user) {
        return userRepository.findById(user.getId())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .orElse(null);
    }

}
