CREATE TABLE BOOK (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author varchar(255) NOT NULL,
    isbn varchar(255) not null ,
    quantity int not null
)

CREATE TABLE bookcopy (
      id int not null primary key,
      book_id INT NOT NULL,
      status ENUM('available', 'not available') NOT NULL,
      FOREIGN KEY (book_id) REFERENCES BOOK(id)
)

CREATE table reservation (
     id int not null primary key,
     bookcopy_id int not null,
     member_id int not null,
     borrowing_date date not null,
     return_date date not null,
     foreign key (bookcopy_id) references bookcopy(id)
     foreign key (member_id) references member(id);
)

CREATE TABLE member (
    id int not null primary key ,
    name varchar(255) not null ,
    gender varchar(255) not null ,
    member_number int not null
)

