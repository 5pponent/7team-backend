package team7.capstone.repository.feed;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team7.capstone.domain.FeedVO;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface FeedRepository {

    Optional<FeedVO> save(FeedVO feed);

    Optional<FeedVO> findBySeq(Long feed_seq);

    List<FeedVO> getFeeds(Long lastFeed_seq);

    void deleteFeed(Long feed_seq);

    void modifyFeed(FeedVO feed);

}
