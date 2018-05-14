package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.User;


import java.awt.print.Book;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {



}
