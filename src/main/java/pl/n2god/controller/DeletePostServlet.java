package pl.n2god.controller;

import pl.n2god.model.User;
import pl.n2god.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deletePost", urlPatterns = "/deletePost")
public class DeletePostServlet extends HttpServlet {

    private PostService postService = PostService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        postService.delete(Long.parseLong(id));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
