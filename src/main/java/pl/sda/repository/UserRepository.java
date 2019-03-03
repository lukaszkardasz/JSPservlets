package pl.sda.repository;

import pl.sda.model.User;
import pl.sda.model.enimeration.Role;

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
        users.add(new User("user", "user1", Role.USER));
        users.add(new User("admin", "admin1", Role.ADMIN));
        users.add(new User("test", "test1", Role.USER));
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserByLoginData(String login, String password) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findFirst();
    }

}
