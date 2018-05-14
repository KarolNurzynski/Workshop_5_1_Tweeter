package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Post;
import pl.coderslab.model.Tag;

import java.awt.print.Book;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByTagsId(Long tagsId);
    List<Post> findAllByTagsName(String tagsName);

    @Query("Select p from Post p Join p.tags t Where t in  :tags")
    List<Book> findAllPostByTagList(@Param("tags") List<Tag> tags);

}



