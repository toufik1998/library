package domain;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String gender;
    private String member_code;
    private List<Reservation> reservations;

    public Member(String name, String gender, String member_code){
        this.name = name;
        this.gender = gender;
        this.member_code = member_code;
        this.reservations = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getMember_code(){
        return member_code;
    }
    public void setMember_code(String member_code){
        this.member_code = member_code;
    }

    public List<Reservation> getReservations(){
        return reservations;
    }
    public void setReservations(List<Reservation> reservations){
        this.reservations = reservations;
    }
}