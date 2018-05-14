package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Post;
import pl.coderslab.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {



}
