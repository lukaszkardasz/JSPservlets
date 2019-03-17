package pl.n2god.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.Objects;

/**
 * @author n2god on 17/03/2019
 * @project JSP
 */
public class DbUtil {

    public static final String HOST = "localhost";
    public static final int PORT = 27017;
    public static final String DB_NAME = "n2god_blog";
    private static MongoClient instance = null;

    public static MongoDatabase getConnection() {
        if (Objects.isNull(instance)) {
            instance = new MongoClient(HOST, PORT);
        }
        return instance.getDatabase(DB_NAME);
    }

    public static void closeConnection() {
        instance.close();
        instance = null;
    }
}
