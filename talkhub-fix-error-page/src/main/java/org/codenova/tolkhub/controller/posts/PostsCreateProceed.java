package org.codenova.tolkhub.controller.posts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.tolkhub.model.deo.PostsDAO;

import java.io.IOException;

@WebServlet("/post-create-proceed")
public class PostsCreateProceed extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String writerId = req.getParameter("writerId");
        String category = req.getParameter("category");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        boolean posts = PostsDAO.create(
                writerId,
                category,
                title,
                content
        );

        if(posts){
            req.getRequestDispatcher("WEB-INF/views/posts/posts-list").forward(req,resp);
        }

        req.getRequestDispatcher("WEB-INF/views/posts/posts-list-fail").forward(req,resp);
    }
}
