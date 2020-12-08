package ru.geekbrains.springlesson2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springlesson2.dto.BookDto;
import ru.geekbrains.springlesson2.entities.Book;
import ru.geekbrains.springlesson2.exceptions.BookstoreError;
import ru.geekbrains.springlesson2.exceptions.ResourceNotFoundException;
import ru.geekbrains.springlesson2.services.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
@Api("Set of endpoints for books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ApiOperation("Returns all books")
    public List<BookDto> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return books.stream().map(BookDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a specific book by their identifier. 404 if does not exist.")
    public BookDto getBookById(@ApiParam("Id of the book to be obtained. Cannot be empty.") @PathVariable Long id) {
        Book b = bookService.getOneById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find book with id: " + id));
        return new BookDto(b);
    }

    @PostMapping
    @ApiOperation("Creates a new book. If id != null, then throw bad request response")
    public ResponseEntity<?> createNewBook(@RequestBody Book b) {
        if (b.getId() != null) {
            return new ResponseEntity<>(new BookstoreError(HttpStatus.BAD_REQUEST.value(), "Id must be null for new entity"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookService.save(b), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Modify book")
    public ResponseEntity<?> modifyBook(@RequestBody Book b) {
        if (b.getId() == null) {
            return new ResponseEntity<>(new BookstoreError(HttpStatus.BAD_REQUEST.value(), "Id must be not null for new entity"), HttpStatus.BAD_REQUEST);
        }
        if (!bookService.existsById(b.getId())) {
            return new ResponseEntity<>(new BookstoreError(HttpStatus.BAD_REQUEST.value(), "Book with id: " + b.getId() + " doesn't exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookService.save(b), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete book")
    public void deleteById(@ApiParam("Id of the book") @PathVariable Long id) {
        bookService.deleteById(id);
    }
}
