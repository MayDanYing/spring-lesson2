package ru.geekbrains.springlesson2.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class BookstoreError {
    private int status;
    private String message;
    private Date timestamp;

    public BookstoreError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
