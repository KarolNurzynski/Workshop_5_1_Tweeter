package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Tweet;
import pl.coderslab.model.User;

import java.awt.print.Book;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByUserId(Long userId);


    @Query("Select t from Tweet t where t.tweetText like:tweetText order by t.created desc")
    List<Tweet> findAllTweetsByTitleStartingWithSortedByCreated(@Param("tweetText") String tweetTextPart);

}
