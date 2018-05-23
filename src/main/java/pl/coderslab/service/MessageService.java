//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Message;
import pl.coderslab.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public Message findMessage(Long id) {
        return messageRepository.findOne(id);
    }

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> findAllMessagesOrderByCreatedDesc() {
        return messageRepository.findAllByOrderByCreatedDesc();
    }

    public List<Message> findAllMessagesBySenderIdOrderByCreatedDesc(Long id) {
        return messageRepository.findAllBySenderIdOrderByCreatedDesc(id);
    }

    public List<Message> findAllMessagesByReceiverIdOrderByCreatedDesc(Long id) {
        return messageRepository.findAllByReceiverIdOrderByCreatedDesc(id);
    }

    public Message editMessage(Message message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.delete(id);
    }

}
