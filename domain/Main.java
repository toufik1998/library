package domain;

import domain.Member;
import repository.DbConnection;
import repository.MemberRepository;
import service.MemberService;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library_management";
        String username = "root";
        String password = "";

        // Create a database connection
        DbConnection dbConnection = new DbConnection(url, username, password);

        // Create an instance of MemberRepository and MemberService
        MemberRepository memberRepository = new MemberRepository(dbConnection.getConnection());
        MemberService memberService = new MemberService(memberRepository);

        // Create a new member
        Member member = new Member("Youness Ahasla", "Male", "1234");

//         Add the member to the database
        memberService.addMember(member);

        // Update a member
//        Member memberToUpdate = new Member("John Doe", "Male", "123");
//        memberToUpdate.setName("John Smith");
//        memberRepository.updateMember(memberToUpdate);

        // Delete a member
//        String memberCodeToDelete = "1234";
//        memberRepository.deleteMember(memberCodeToDelete);

        // Close the database connection
        dbConnection.closeConnection();
    }
}