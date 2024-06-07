package dao;

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import model.*;

public class UsersDAO extends MyDAO {
    public Users Login(String username, String pass) {
        xSql = "select * from Users where username = ? and password = ?";
        String xUsername, xPass;
        int xId, xRole;
        Users x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("ID");
                xUsername = rs.getString("username");
                xPass = rs.getString("password");
                xRole = rs.getInt("role_id");

                x = new Users(xId, xUsername, xPass, xRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    // hàm tra vê danh sách tat ca nguoi dung
    public List<Users> getAllUser() {
        List<Users> list = new ArrayList<>();
        xSql = "select * from users";
        String xPass, xUsername;
        int xId, xRole;
        Users x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("ID");
                xUsername = rs.getString("username");
                xPass = rs.getString("password");
                xRole = rs.getInt("role_id");

                x = new Users(xId, xUsername, xPass, xRole);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // hàm dang kí
    public void Register(String username, String pass) {
        xSql = "INSERT INTO Users (username, Password, role_id) VALUES ( ?, ?, ?)";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setInt(3, 2);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
