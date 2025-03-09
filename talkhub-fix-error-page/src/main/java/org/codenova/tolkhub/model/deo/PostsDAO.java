package org.codenova.tolkhub.model.deo;

import org.codenova.tolkhub.Util.ConnectionFactory;
import org.codenova.tolkhub.model.vo.Posts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostsDAO {

    public static boolean create(
            String writerId,
            String category,
            String title,
            String content
    ) {
        boolean result = false;

        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("insert into posts values(null, ?, ?, ?, ?, 0, 0, now(), now())");
            ps.setString(1, writerId);
            ps.setString(2, category);
            ps.setString(3, title);
            ps.setString(4, content);

            int r = ps.executeUpdate();
            result = true;

            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    public static List<Posts> selectAll() {

        List<Posts> list = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts order by id asc");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Posts posts = new Posts(
                        rs.getInt("id"),
                        rs.getString("writer_id"),
                        rs.getString("category"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getInt("views"),
                        rs.getInt("likes"),
                        rs.getDate("writed_at"),
                        rs.getDate("modified_at")
                );

                list.add(posts);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return list;
    }

    public static Posts selectById(int id) {

        Posts posts = null;

        try {

            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts where id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                posts = new Posts(id,
                        rs.getString("writer_id"),
                        rs.getString("category"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getInt("views"),
                        rs.getInt("likes"),
                        rs.getDate("writed_at"),
                        rs.getDate("modified_at")
                        );
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return posts;
    }

    public static boolean updateViews(int id){

        boolean result = false;

        try(Connection conn = ConnectionFactory.open()) {

            PreparedStatement ps = conn.prepareStatement("update posts set views = views+1 where id=?");
            ps.setInt(1, id);

            int r = ps.executeUpdate();

            if(r>0){
                result = true;
            }

            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public static boolean updatelikes(int postsid){

        boolean result = false;

        try(Connection conn = ConnectionFactory.open()) {

            PreparedStatement ps = conn.prepareStatement("update posts set likes = likes+1 where id=?");
            ps.setInt(1, postsid);

            int r = ps.executeUpdate();

            if(r>0){
                result = true;
            }

            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }
}

