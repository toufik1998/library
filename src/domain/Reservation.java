package domain;

import java.sql.*;

public class Reservation {
    private int memberId;
    private int copyId;
    private Date borrowing_date;
    private Date return_date;

    public Reservation(int memberId, int copyId, Date borrowingDate, Date returnDate) {
        this.memberId = memberId;
        this.copyId = copyId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId (int memberId) {
        this.memberId = memberId;
    }

    public int getCopyId() {
        return copyId;
    }

    public void setCopyId (int copyId) {
        this.copyId = copyId;
    }

    public java.sql.Date getBorrowing_date() {
        return (java.sql.Date) borrowing_date;
    }

    public void setBorrowing_date(Date borrowing_date) {
        this.borrowing_date = borrowing_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}