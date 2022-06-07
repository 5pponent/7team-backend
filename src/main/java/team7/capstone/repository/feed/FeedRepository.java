package team7.capstone.repository.feed;

import team7.capstone.domain.FeedVO;
import java.util.List;
import java.util.Optional;

public interface FeedRepository {

    Optional<FeedVO> save(FeedVO feed);

    Optional<FeedVO> findBySeq(Long feed_seq);

    List<FeedVO> getFeedsFirst();
    List<FeedVO> getFeeds(Long lastFeed_seq);

    void deleteFeed(Long feed_seq);

    void modifyFeed(FeedVO feed);

}
