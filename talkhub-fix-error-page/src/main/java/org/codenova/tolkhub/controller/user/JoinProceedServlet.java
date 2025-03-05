package org.codenova.tolkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.tolkhub.model.deo.UserDAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet("/join-proceed")
public class JoinProceedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean error = false;

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        int birth = Integer.parseInt(req.getParameter("birth"));

        int a = 0;
        int number = 0;
        for(int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
                a++;
            }else if(c >= '0' && c <= '9'){
                number++;
            }
        }

        if(id.length() == 0){
            req.setAttribute("idError", "아이디를 적어주세요");
            error = true;
        }else if(id.length() < 3){
            req.setAttribute("idError", "아이디를 3글자 이상 적어주세요");
            error = true;}

        if(a > 0 && number > 0 && password.length() >= 6){
        }else if(password.length() == 0){
            req.setAttribute("passError", "비밀번호를 입력해주세요");
            error = true;
        }else{
            req.setAttribute("passError", "비밀번호가 잘못되었습니다(영어 숫자 포함, 6글자 이상)");
            error = true;
        }

        if(nickname.length() == 0){
            req.setAttribute("nickError", "닉네임을 적어주세요)");
            error = true;
        }

        if(error){
            req.getRequestDispatcher("WEB-INF/views/user/join-fail.jsp").forward(req, resp);
        }

        boolean result = false;

        try {
            result = UserDAO.create(
                    id,
                    password,
                    nickname,
                    gender,
                    birth);

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e.toString());
            req.setAttribute("idError", "아이디가 중복되었거나 사용할 수 없습니다");

        } catch (Exception e) {
            System.out.println("create : " + e.toString());
        }

        if (result) {
            resp.sendRedirect(req.getContextPath() + "/index");
        } else {
            req.setAttribute("error", "아이디가 존재하거나 정보가 잘못되었습니다");
            req.getRequestDispatcher("WEB-INF/views/user/join-fail.jsp").forward(req, resp);
        }
    }
}