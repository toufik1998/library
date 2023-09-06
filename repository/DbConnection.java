package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DbConnection {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/library_management";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}