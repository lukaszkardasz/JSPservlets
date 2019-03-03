package pl.sda.controller;

import pl.sda.model.User;
import pl.sda.model.enimeration.Role;
import pl.sda.repository.UserRepository;
import pl.sda.util.Message;
import pl.sda.util.ValidationError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", Message.error("Błąd!"));
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");

        Optional<ValidationError> error = validateUserData(login, password, repeatPassword);

        if (!error.isPresent()) {
            User user = new User(login, password, Role.USER);
            userRepository.save(user);
            req.setAttribute("message", Message.success("Twoje konto zostało zarejestrowane, możesz się zalogować!"));
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", Message.error(error.get().getErrorMsg()));
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        }

    }

    private Optional<ValidationError> validateUserData(String login, String password, String repeatPassword) {
        Optional<ValidationError> error = Optional.empty();
        if (userRepository.userExist(login)) {
            error = Optional.of(new ValidationError("login", "Ten login jest już zajęty!"));
        } else if (!password.equals(repeatPassword)) {
            error = Optional.of(new ValidationError("password", "Wpisane hasła nie są takie same!"));
        }
        return error;
    }
}
