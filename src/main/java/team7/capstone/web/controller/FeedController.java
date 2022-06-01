package team7.capstone.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import team7.capstone.domain.FeedVO;

@Slf4j
@RestController
@RequestMapping("/feed")
public class FeedController {

    @GetMapping("/{feed_seq}")
    public Object getFeed(@PathVariable Long feed_seq) {
        return "";
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
