package pl.sda.controller;

import pl.sda.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userInfo", urlPatterns = "/user-info")
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        PrintWriter writer = resp.getWriter();
        if (user != null) {
            writer.println("Login: " + user.getLogin());
            writer.println("Password: " + user.getPassword());
        } else {
            writer.println("Nie jesteś zalogowany");
        }

    }
}
