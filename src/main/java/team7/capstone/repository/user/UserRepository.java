package team7.capstone.repository.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team7.capstone.domain.UserVO;

import java.util.Optional;

@Repository
@Mapper
public interface UserRepository {

    UserVO save(UserVO user);
    Optional<UserVO> findById(String id);
    Optional<UserVO> findBySeq(Long user_seq);

    void updateUser(UserVO user);
    void deleteUser(String id);

}
