package org.example.certify;

import java.sql.*;
import java.util.Properties;

public class MySQLConnect {
    public static void main(String[] args) {
        String url1 = "jdbc:mysql://localhost:3306/certify?useSSL=false";
        String user = "root";
        String password = "root";
        String sql = "select name, country from users where id = ?";
        try (Connection conn1 = DriverManager.getConnection(url1, user, password);
             PreparedStatement ps = conn1.prepareStatement(sql)) {
            if (conn1 != null) {
                System.out.println("Connected to the database test1");
            }
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}