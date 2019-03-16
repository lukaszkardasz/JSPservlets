package pl.n2god.service;

import pl.n2god.model.User;
import pl.n2god.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;
    private static UserService instance = null;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        this.userRepository = UserRepository.getInstance();
    }



    public Optional<User> loginUser(String login, String password) {
        return userRepository.getUserByLoginData(login, password);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public Optional<User> getUser(Long id){
        return userRepository.getUser(id);
    }

}
