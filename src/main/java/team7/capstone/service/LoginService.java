package team7.capstone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team7.capstone.domain.JoinVO;
import team7.capstone.domain.LoginVO;
import team7.capstone.domain.UserVO;
import team7.capstone.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public UserVO login(LoginVO form) {
        return userRepository.findById(form.getId())
                .filter(u -> u.getPassword().equals(form.getPassword()))
                .orElse(null);
    }

    public UserVO join(JoinVO form) {
        return userRepository.save(new UserVO(form.getId(), form.getPassword(), form.getName(), form.getEmail()));
    }

    /**
     * true : 이미 존재하는 ID
     */
    public boolean idCheck(String id) {
        if (userRepository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

}
