package team7.capstone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team7.capstone.domain.FeedVO;
import team7.capstone.repository.feed.FeedRepository;

@Service
@RequiredArgsConstructor
public class FeedService {

    @Autowired
    private final FeedRepository feedRepository;

    public FeedVO getFeed(Long feed_seq) {
        return feedRepository.findBySeq(feed_seq).get();
    }
}
