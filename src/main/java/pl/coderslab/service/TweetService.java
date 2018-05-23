//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Tweet;
import pl.coderslab.external.BCrypt;
import pl.coderslab.repository.TweetRepository;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    public void saveTweet(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    public Tweet findTweet(Long id) {
        return tweetRepository.findOne(id);
    }

    public List<Tweet> findAllTweets() {
        return tweetRepository.findAll();
    }

    public List<Tweet> findAllTweetsOrderByCreatedDesc() {
        return tweetRepository.findAllByOrderByCreatedDesc();
    }

    public List<Tweet> findAllTweetsByUserIdOrderByCreatedDesc(Long id) {
        return tweetRepository.findAllByUserIdOrderByCreatedDesc(id);
    }

    public Tweet editTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public void deleteTweet(Long id) {
        tweetRepository.delete(id);
    }

}
