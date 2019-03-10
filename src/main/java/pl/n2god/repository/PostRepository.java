package pl.n2god.repository;

import pl.n2god.model.Post;
import pl.n2god.util.IdGenerator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {


    private List<Post> posts;
    private static PostRepository instance = null;

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

    private PostRepository() {
        posts = new ArrayList<>();
        posts.add(new Post(IdGenerator.next(), LocalDateTime.now(), "First Post is critial"));
        posts.add(new Post(IdGenerator.next(),LocalDateTime.now(), "Second post is simple Lorem ipsum dolor men"));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void save(Post post) {
        posts.add(post);
    }

}
