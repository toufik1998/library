package repository;

import domain.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {
    private DbConnection dbConnection;

    public MemberRepository(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addMember(Member member) {
        String query = "INSERT INTO member (name, gender, member_code) VALUES (?, ?, ?)";

        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(query)) {
            statement.setString(1, member.getName());
            statement.setString(2, member.getGender());
            statement.setString(3, member.getMemberCode());

            statement.executeUpdate();
            System.out.println("Member added");
        } catch (SQLException e) {
            System.out.println("something went wrong");
        }
    }

    public void updateMember(Member member) {
        String query = "UPDATE member SET name = ?, gender = ? WHERE member_code = ?";

        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(query)) {
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
            System.out.println("Failed to update member: " + e.getMessage());
        }
    }

    public void deleteMember(String memberCode) {
        String query = "DELETE FROM member WHERE member_code = ?";

        try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(query)) {
            statement.setString(1, memberCode);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Member deleted successfully");
            } else {
                System.out.println("Member not found");
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete member: " + e.getMessage());
        }
    }

    public boolean isMemberExists(int memberNumber) throws SQLException {
        String query = "SELECT * FROM member WHERE member_code = ?";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        statement.setInt(1, memberNumber);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? true : false;
    }

    public int getMemberId(int memberNumber) throws SQLException {
        String query = "SELECT id FROM member WHERE member_code = ?";

        PreparedStatement statement = dbConnection.getConnection().prepareStatement(query);
        statement.setInt(1, memberNumber);
        ResultSet resultSet = statement.executeQuery();

        int memberId = -1; // Default value if member is not found

        if (resultSet.next()) {
            memberId = resultSet.getInt("id");
        }

        return memberId;
    }
}