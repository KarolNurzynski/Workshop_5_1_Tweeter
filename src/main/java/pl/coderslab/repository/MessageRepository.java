//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.Tweet;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByReceiverIdOrderByCreatedDesc(Long id);

    List<Message> findAllBySenderIdOrderByCreatedDesc(Long id);

    List<Message> findAllByOrderByCreatedDesc();

}
