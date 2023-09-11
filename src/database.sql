-- Create database and access it
CREATE DATABASE library_management;

USE library_management;

-- Crete Tables

CREATE TABLE book (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    isbn VARCHAR(255) NOT NULL UNIQUE,
    quantity INT UNSIGNED NOT NULL
)

CREATE TABLE bookcopy (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    book_id INT NOT NULL,
    status ENUM('available', 'not available', 'lost') NOT NULL
)

CREATE TABLE reservation (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    copy_id INT NOT NULL,
    member_id INT NOT NULL,
    borrowing_date DATE NOT NULL,
    return_date DATE
)

CREATE TABLE author (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
)

CREATE TABLE member (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    member_code INT NOT NULL
)

-- Alter tables to add foreign keys

ALTER TABLE book ADD FOREIGN KEY(author_id) REFERENCES author(id);

ALTER TABLE bookcopy ADD FOREIGN KEY(book_id) REFERENCES book(id);

ALTER TABLE reservation ADD FOREIGN KEY(copy_id) REFERENCES bookcopy(id);

Alter TABLE reservation ADD FOREIGN KEY (member_id) REFERENCES member(id);

ALTER TABLE book ADD COLUMN year YEAR AFTER author_id;

-- Insert into author table

INSERT INTO Author (first_name, last_name) VALUES ('Fyodor' , 'Dostoevsky');
INSERT INTO Author (first_name, last_name) VALUES ('George' , 'Orwell');
INSERT INTO Author (first_name, last_name) VALUES ('Hank' , 'Green');

-- Insert into book table

INSERT INTO book (title, author_id, year, isbn, quantity)
VALUES ('Crime and Punishment', 1, 1901, '0-9767736-6-X', 2);

INSERT INTO book (title, author_id, year, isbn, quantity)
VALUES ('The Brothers Karamazov', 1, 1901, '1-1237736-6-Z', 2);

INSERT INTO book (title, author_id, year, isbn, quantity)
VALUES ('Nineteen Eighty-Four', 2, 1949, '2-2347735-6-S', 2);

INSERT INTO book (title, author_id, year, isbn, quantity)
VALUES ('Animal Farm', 2, 1945, '4-2344335-6-Y', 2);

-- Update a row from member table
UPDATE member SET name = 'Youness', gender = 'male', member_code = 9876 WHERE id = 1;

-- Delete a row from bookcopy table

DELETE FROM bookcopy WHERE id = 6;
