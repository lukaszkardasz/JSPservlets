package pl.n2god.repository;

import pl.n2god.model.User;
import pl.n2god.model.enimeration.Role;
import pl.n2god.util.IdGenerator;

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
        save(new User(1L, "user", "user1", Role.USER));
        save(new User(2L,"admin", "admin1", Role.ADMIN));
        save(new User(3L,"test", "test1", Role.USER));
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
        user.setId(IdGenerator.next());
        users.add(user);
    }

    public boolean userExist(String login) {
        return users.stream().anyMatch(user -> user.getLogin().equals(login));
    }

    public Optional<User> getUser(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
