package domain;

import domain.enums.Status;

public class BookCopy {
    private Book book;
    private Status status;
    private Reservation reservation;

    public BookCopy(Book book, Status status){
        this.book = book;
        this.status = status;
    }

    public Book getBook(){
        return book;
    }
    public void setBook(Book book){
        this.book = book;
    }

    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    
    public Reservation getReservation(){
        return reservation;
    }
    public void setReservation(Reservation reservation){
        this.reservation = reservation;
    }


}

