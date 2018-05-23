package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.service.CommentService;

public class CommentConverter implements Converter<String, Comment> {

    @Autowired
    CommentService commentService;

    @Override
    public Comment convert(String s) {
        return commentService.findComment(Long.parseLong(s));
    }
}

