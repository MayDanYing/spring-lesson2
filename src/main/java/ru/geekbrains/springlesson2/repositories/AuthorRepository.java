package ru.geekbrains.springlesson2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springlesson2.entities.Author;
import ru.geekbrains.springlesson2.entities.Book;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
//
//    @Query("select title from books join authors on(books.author_id = authors.id) where authors.last_name = ?1")
//    List<Book> findBookByAuthorsName(String authorsName);
}
