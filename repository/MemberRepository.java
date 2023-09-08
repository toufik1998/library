package repository;

import domain.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberRepository {
    private Connection connection;

    public MemberRepository(Connection connection) {
        this.connection = connection;
    }

    public void addMember(Member member) {
        String query = "INSERT INTO member (name, gender, member_code) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, member.getName());
            statement.setString(2, member.getGender());
            statement.setString(3, member.getMemberCode());

            statement.executeUpdate();
            System.out.println("Member dkhal f database");
        } catch (SQLException e) {
            System.out.println("member madkhalch");
        }
    }

    public void updateMember(Member member) {
        String query = "UPDATE member SET name = ?, gender = ? WHERE member_code = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, member.getName());
            statement.setString(2, member.getGender());
            statement.setString(3, member.getMemberCode());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Member updated successfully");
            } else {
                System.out.println("Member not found");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update member");
        }
    }

    public void deleteMember(String memberCode) {
        String query = "DELETE FROM member WHERE member_code = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, memberCode);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Member deleted successfully");
            } else {
                System.out.println("Member not found");
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete member:");
        }
    }
}