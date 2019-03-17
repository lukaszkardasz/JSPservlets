package pl.n2god.filter;


import org.apache.commons.lang3.math.NumberUtils;
import pl.n2god.model.Post;
import pl.n2god.model.User;
import pl.n2god.service.PostService;
import pl.n2god.util.Message;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;


@WebFilter(filterName = "objectOwnerFilter", servletNames = {"deletePostServlet"})
public class ObjectOwnerFilter implements Filter {

    private PostService postService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        postService = PostService.getInstance();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String strId = req.getParameter("id");
        if (NumberUtils.isNumber(strId)) {
            Long id = Long.parseLong(strId);
            Optional<Post> optPost = postService.getPost(id);
            if (optPost.isPresent()) {
                Post post = optPost.get();
                User postAuthor = post.getUser();
                User loggedUser = (User) ((HttpServletRequest) req).getSession().getAttribute("user");
                if (postAuthor.equals(loggedUser) || (Objects.nonNull(loggedUser) && loggedUser.isAdmin())) {
                    filterChain.doFilter(req, resp);
                } else {
                    req.setAttribute("message", Message.error("Nie masz uprawnień!"));
                }
            }
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
    }
}
