package org.codenova.tolkhub.model.deo;

import org.codenova.tolkhub.Util.ConnectionFactory;
import org.codenova.tolkhub.model.vo.User;

import java.sql.*;

public class UserDAO {

    // 1. 데이터 등록
    // insert into users values(?, ?, ?, ?, ?, now())
    public static boolean create(String id, String password, String nickname, String gender, int birth) throws ClassNotFoundException, SQLException{
        boolean result = false;
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, now())");
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.setString(4, gender);
            ps.setInt(5, birth);

            int r = ps.executeUpdate();
            result = true;

            conn.close();
        return result;
    }

    public static User findById(String specificId) {
        User one = null;
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");
            ps.setString(1, specificId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                one = new User(
                        specificId,
                        rs.getString("password"),
                        rs.getString("nickname"),
                        rs.getString("gender"),
                        rs.getInt("birth"),
                        rs.getDate("created_at")
                );
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("userDAO.create : " + e.toString());
        }
        return one;
    }
}
