package pl.n2god.repository;

import com.google.common.collect.Lists;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import pl.n2god.config.DbUtil;
import pl.n2god.model.User;
import pl.n2god.model.enimeration.Role;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;


public class UserRepository {

    private static UserRepository instance = null;
    private MongoCollection<Document> users;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        users = DbUtil.getConnection().getCollection("users");
        save(new User("user", "user1", Role.USER));
        save(new User("admin", "admin1", Role.ADMIN));
        save(new User("test", "test1", Role.USER));
    }

    public List<User> getUsers() {
        FindIterable<Document> documents = users.find();
        return Lists.newArrayList(documents).stream()
//              .map(user -> User.fromDocument(user))
                .map(User::fromDocument)
                .collect(Collectors.toList());
    }

    public Optional<User> getUserByLoginData(String login, String password) {
        Document document = users
                .find(and(eq("login", login), eq("password", password))).first();
        return Optional.ofNullable(User.fromDocument(document));
    }


    public void save(User user) {

        if (!userExist(user.getLogin())) {
            users.insertOne(user.getUserAsDocument());
        }
    }

    public boolean userExist(String login) {
        return Objects.nonNull(users.find(eq("login", login)).first());
    }

}
