package org.codenova.tolkhub.controller.user;

import com.mysql.cj.Session;
import com.mysql.cj.protocol.x.Notice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.tolkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("user") == null){
            req.getSession().setAttribute("callback", req.getContextPath()+"/profile");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User)req.getSession().getAttribute("user");

        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/views/user/profile.jsp").forward(req,resp);
    }
}
