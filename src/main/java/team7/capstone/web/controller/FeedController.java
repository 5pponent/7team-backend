package team7.capstone.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team7.capstone.domain.FeedVO;
import team7.capstone.service.FeedService;
import team7.capstone.web.ResponseForm;

import static team7.capstone.web.ResponseForm.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {

    private final FeedService feedService;

    @GetMapping("/{feed_seq}")
    public Object getFeed(@PathVariable Long feed_seq) {
        FeedVO feed = feedService.getFeed(feed_seq);
        return ok(feed);
    }

    @GetMapping("/list/{lastFeed_seq}")
    public Object getFeeds(@PathVariable Long lastFeed_seq) {
        return "";
    }

    @PostMapping("/write")
    public Object writeFeed(FeedVO form) {
        return "";
    }

    @PutMapping("/{feed_seq}")
    public Object editFeed(@PathVariable Long feed_seq, FeedVO form) {
        return "";
    }

    @DeleteMapping("/{feed_seq}")
    public Object deleteFeed(@PathVariable Long feed_seq) {
        return "";
    }
}
