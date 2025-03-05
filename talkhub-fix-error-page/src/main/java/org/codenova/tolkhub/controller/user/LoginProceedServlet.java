package org.codenova.tolkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.codenova.tolkhub.model.deo.UserDAO;
import org.codenova.tolkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/login-proceed")
public class LoginProceedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        User user = UserDAO.findById(id);

        if(user != null) {
            if (password.equals(user.getPassword())) {

                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/index");
            }else{
                req.setAttribute("id", id);
                req.getRequestDispatcher("WEB-INF/views/user/login-fail.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("id", id);
            req.getRequestDispatcher("WEB-INF/views/user/login-fail.jsp").forward(req,resp);
        }
    }
}
