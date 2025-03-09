package org.codenova.tolkhub.controller.posts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.tolkhub.model.deo.PostsDAO;
import org.codenova.tolkhub.model.deo.PostsLikeDAO;
import org.codenova.tolkhub.model.vo.Posts;
import org.codenova.tolkhub.model.vo.PostsLikes;
import org.codenova.tolkhub.model.vo.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/posts-like-proceed")
public class PostsLikeProceed extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        if (req.getSession().getAttribute("user") == null) {
            req.getSession().setAttribute("callback", req.getContextPath() + "/posts-list-view?id=" + id);
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) req.getSession().getAttribute("user");
        List<PostsLikes> list = PostsLikeDAO.likesList(user.getId());

        boolean like = false;
        for (PostsLikes likes : list) {
            if (likes.getPostsId() == id) {
                like = true;

            }
        }
        if (!like) {
            PostsDAO.updatelikes(id);

            PostsLikes log = PostsLikes.builder().postsId(id).userId(user.getId()).build();
            PostsLikeDAO.create(log);
        }

        Posts posts = PostsDAO.selectById(id);

        req.setAttribute("posts", posts);
        req.getRequestDispatcher("WEB-INF/views/posts/posts-list-view.jsp").forward(req, resp);
    }
}

