create table authors (id bigint auto_increment primary key, first_name varchar(255), last_name varchar(255), birth_date int);
insert into authors (first_name, last_name, birth_date)
values
('John', 'Tolkien', 1892),
('Clive', 'Lewis', 1898);

create table books (id bigint auto_increment primary key, title varchar(255), edition_year int, author_id bigint references authors(id));
insert into books (title, edition_year, author_id)
values
('The Lord of the Rings', 1954, 1),
('Hobbit', 1937, 1),
('The Silmarillion', 1977, 1),
('The Lion, the Witch and the Wardrobe', 1950, 2),
('The Horse and His Boy', 1954, 2);