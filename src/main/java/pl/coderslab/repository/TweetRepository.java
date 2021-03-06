//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.coderslab.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByUserIdOrderByCreatedDesc(Long id);

    List<Tweet> findAllByOrderByCreatedDesc();
}
