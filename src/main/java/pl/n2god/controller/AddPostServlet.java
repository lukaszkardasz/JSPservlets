package pl.n2god.controller;

import pl.n2god.model.User;
import pl.n2god.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addPost", urlPatterns = "/addPost")
public class AddPostServlet extends HttpServlet {

    private PostService postService = PostService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        User user = (User)req.getSession().getAttribute("user");
        postService.addPost(text, user);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);



    }
}
