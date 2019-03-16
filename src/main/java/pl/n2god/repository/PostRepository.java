package pl.n2god.repository;

import pl.n2god.model.Post;
import pl.n2god.service.UserService;
import pl.n2god.util.IdGenerator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    private UserService userService = UserService.getInstance();

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
        save(new Post("text cośtam", userService.getUser(1L).get()));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void save(Post post) {
        post.setPostId(IdGenerator.next());
        post.setDate(LocalDateTime.now());
        posts.add(post);
    }

    public void delete(long id){

        Optional<Post> postToDelete = posts.stream().filter(post -> post.getPostId().equals(id)).findFirst();
        postToDelete.ifPresent(post -> posts.removeIf(p -> p.equals(post)));
    }

}
