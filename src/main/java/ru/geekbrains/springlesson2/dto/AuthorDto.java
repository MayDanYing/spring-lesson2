package ru.geekbrains.springlesson2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springlesson2.entities.Author;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long birthDate;
    private List<BookDto> booksCount;

    public AuthorDto(Author a) {
        this.id = a.getId();
        this.firstName = a.getFirstName();
        this.lastName = a.getLastName();
        this.birthDate = a.getBirthDate();
        this.booksCount = a.getBooks().stream().map(BookDto::new).collect(Collectors.toList());
    }
}