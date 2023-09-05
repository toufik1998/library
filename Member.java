public class Member {
    private String name;
    private String gender;
    private int memberNumber;

    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public int getMemberNumber(){
        return memberNumber;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setGender(String newGender){
        this.gender= newGender;
    }
    public void setMemberNumber(int newMemberNumber){
        this.memberNumber = newMemberNumber;
    }

}
