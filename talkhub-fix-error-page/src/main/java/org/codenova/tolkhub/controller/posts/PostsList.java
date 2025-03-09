package org.codenova.tolkhub.controller.posts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.tolkhub.model.deo.PostsDAO;
import org.codenova.tolkhub.model.vo.Posts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/posts-list")
public class PostsList extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Posts> list = PostsDAO.selectAll();

        req.setAttribute("posts", list);

        req.getRequestDispatcher("WEB-INF/views/posts/posts-list.jsp").forward(req,resp);
    }
}
