package pl.n2god.repository;

import pl.n2god.model.User;
import pl.n2god.model.enimeration.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users;
    private static UserRepository instance = null;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        users = new ArrayList<>();
        users.add(new User("user", "user123", Role.USER));
        users.add(new User("admin", "admin123", Role.ADMIN));
        users.add(new User("test", "test123", Role.USER));
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserByLoginData(String login, String password) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findFirst();
    }


    public void save(User user) {
        users.add(user);
    }

    public boolean userExist(String login) {
        return users.stream().anyMatch(user -> user.getLogin().equals(login));
    }
}
