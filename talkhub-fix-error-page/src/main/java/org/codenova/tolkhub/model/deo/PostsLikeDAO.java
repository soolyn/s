package org.codenova.tolkhub.model.deo;

import org.codenova.tolkhub.Util.ConnectionFactory;
import org.codenova.tolkhub.model.vo.PostsLikes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostsLikeDAO {

    public static boolean create(PostsLikes one){

        String userId = one.getUserId();
        int postsId = one.getPostsId();

        boolean result = false;

        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("insert into posts_likes values(null, ?, ?)");
            ps.setString(1, userId);
            ps.setInt(2, postsId);

            int r = ps.executeUpdate();
            result = true;

            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public static List<PostsLikes> likesList(String userId) {

        List<PostsLikes> list = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts_likes where user_id = ? order by id asc");
            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PostsLikes postsLikes = new PostsLikes(
                        rs.getInt("id"),
                        rs.getString("user_id"),
                        rs.getInt("posts_id")
                );

                list.add(postsLikes);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }
}
