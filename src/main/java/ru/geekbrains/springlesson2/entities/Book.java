package ru.geekbrains.springlesson2.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "edition_year")
    private int editionYear;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
