package com.hotel.dao;
import com.hotel.model.User;
import com.hotel.util.DBUtil;
import java.sql.*;

public class UserDAO {
    public boolean save(User u) {
        String sql = "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRole());
            return ps.executeUpdate()>0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findByEmailPassword(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setRole(rs.getString("role"));
                return u;
            }
        } catch(SQLException e) { e.printStackTrace(); }
        return null;
    }
}
