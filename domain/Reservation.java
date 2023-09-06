package domain;

public class Reservation {
    private Member member;
    private BookCopy copy;
    private String borrowing_date;
    private String return_date;

    public Reservation(Member member, String borrowing_date, String return_date){
        this. member = member;
        this.borrowing_date = borrowing_date;
        this.return_date = return_date;
    }

    public Member getMember(){
        return member;
    }
    public void setMember(Member member){
        this.member = member;
    }

    public BookCopy getCopy(){
        return copy;
    }
    public void setCopy(BookCopy copy){
        this.copy = copy;
    }

    public String getBorrowing_date(){
        return borrowing_date;
    }
    public void setBorrowing_date(String borrowingDate){
        this.borrowing_date = borrowingDate;
    }

    public String getReturn_date(){
        return return_date;
    }
    public void setReturn_date(String returnDate){
        this.return_date = returnDate;
    }
}
