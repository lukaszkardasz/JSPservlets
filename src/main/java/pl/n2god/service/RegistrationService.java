package pl.n2god.service;

import pl.n2god.model.User;
import pl.n2god.model.enimeration.Role;
import pl.n2god.repository.UserRepository;
import pl.n2god.util.ValidationError;

import java.util.Optional;

public class RegistrationService {

    private UserRepository userRepository;
    private static RegistrationService instance = null;

    public static RegistrationService getInstance() {
        if (instance == null) {
            instance = new RegistrationService();
        }
        return instance;
    }

    private RegistrationService() {
        this.userRepository = UserRepository.getInstance();
    }

    public Optional<ValidationError> validateUserData(String login, String password, String repeatPassword) {
        Optional<ValidationError> error = Optional.empty();
        if (userRepository.userExist(login)) {
            error = Optional.of(new ValidationError("login", "Ten login jest już zajęty!"));
        } else if (!password.equals(repeatPassword)) {
            error = Optional.of(new ValidationError("password", "Wpisane hasła nie są takie same!"));
        }
        return error;
    }

    public void registerUser(String login, String password) {
        User user = new User(login, password, Role.USER);
        userRepository.save(user);
    }

}
