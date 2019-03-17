package pl.n2god.model;

import org.bson.Document;
import pl.n2god.model.enimeration.Role;

public class User {
    private String login;
    private String password;
    private Role role;
    private String id;

    public User(String login, String password, Role user) {

    }

    public User(String id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Document document;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return Role.ADMIN.equals(role);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

