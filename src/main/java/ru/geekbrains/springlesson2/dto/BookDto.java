package ru.geekbrains.springlesson2.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springlesson2.entities.Book;

@Data
@NoArgsConstructor
@ApiModel(description = "Product dto in the application.")
public class BookDto {
    @ApiModelProperty(notes = "Unique identifier of the book. No two books can have the same id.", example = "1", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "Title of the book.", example = "Hobbit", required = true, position = 1)
    private String title;

    @ApiModelProperty(notes = "Edition year.", example = "1937", required = true, position = 2)
    private int editionYear;

    @ApiModelProperty(notes = "Author of the book.", example = "Tolkien", required = true, position = 3)
    private String authorName;

    public BookDto(Book b) {
        this.id = b.getId();
        this.title = b.getTitle();
        this.editionYear = b.getEditionYear();
        this.authorName = b.getAuthor().getLastName();
    }
}
