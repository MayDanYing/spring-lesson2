package ru.geekbrains.springlesson2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springlesson2.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
