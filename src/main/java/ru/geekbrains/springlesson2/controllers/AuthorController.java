package ru.geekbrains.springlesson2.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springlesson2.dto.AuthorDto;
import ru.geekbrains.springlesson2.dto.BookDto;
import ru.geekbrains.springlesson2.entities.Author;
import ru.geekbrains.springlesson2.entities.Book;
import ru.geekbrains.springlesson2.exceptions.ResourceNotFoundException;
import ru.geekbrains.springlesson2.repositories.AuthorRepository;
import ru.geekbrains.springlesson2.services.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private AuthorService authorService;
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ApiOperation("Returns all authors")
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return authors.stream().map(AuthorDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        Author author = authorService.getOneById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find category with id: " + id));
        return new AuthorDto(author);
    }

//    //GET /authors/search?authors_name='Lewis'
//    @GetMapping("/search")
//    public List<Book> findBookByAuthorsName(@RequestParam String authorsName) {
//
//        return findBookByAuthorsName(authorsName);
//    }
}