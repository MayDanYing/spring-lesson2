package ru.geekbrains.springlesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLesson2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLesson2Application.class, args);
	}

	// Домашнее задание:
	// 1. Создайте две сущности: авторы и книги, каждая книга написана только одним автором
	// 2. Пропишите REST контроллеры для этих сущностей (для http-методов GET/ *POST)
	// 3. Через REST API дайте возможность запрашивать автора по id со следующей структурой:
	// {
	//   "id": ...,
	//   "name": ...,
	//   "booksCount": ... // количество написанных книг
	// }
	// 4. Реализуйте отправку JSON'а с ошибкой 404, если клиент запросил несуществующий ресурс
	// 5. * Попробуйте прикрутить swagger и описать ваш rest сервис
	// 6. ** Попробуйте реализовать поиск книг по имени автора
	// http://localhost:8189/store/api/v1/books?author_name=Rowling
}
