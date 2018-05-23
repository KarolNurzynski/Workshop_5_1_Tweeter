//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Comment;
import pl.coderslab.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment findComment(Long id) {
        return commentRepository.findOne(id);
    }

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> findAllCommentsOrderByCreatedDesc() {
        return commentRepository.findAllByOrderByCreatedDesc();
    }

    public List<Comment> findAllCommentsByTweetId(Long id) {
        return commentRepository.findAllByTweetId(id);
    }

    public Comment editComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.delete(id);
    }

}
