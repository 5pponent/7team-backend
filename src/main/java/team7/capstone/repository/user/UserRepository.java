package team7.capstone.repository.user;

import team7.capstone.domain.UserVO;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserVO save(UserVO user);
    Optional<UserVO> findById(String user_id);
}
