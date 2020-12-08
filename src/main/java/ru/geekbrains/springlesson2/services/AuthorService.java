package ru.geekbrains.springlesson2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springlesson2.entities.Author;
import ru.geekbrains.springlesson2.entities.Book;
import ru.geekbrains.springlesson2.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getOneById(Long id) {
        return authorRepository.findById(id);

    }
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}