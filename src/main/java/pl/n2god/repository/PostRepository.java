package pl.n2god.repository;

import pl.n2god.model.Post;
import pl.n2god.service.UserService;
import pl.n2god.util.IdGenerator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

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

    public Optional<Post> deletePost(Long id) {
        Optional<Post> optRemovedPost = getPost(id);
        optRemovedPost.ifPresent(removedPost -> posts.removeIf(post -> post.equals(removedPost)));
        return optRemovedPost;
    }

    public Optional<Post> getPost(Long id) {
        return posts.stream().filter(post -> post.getPostId().equals(id)).findFirst();
    }

    public boolean update(Post post) {
        OptionalInt optIndex = IntStream.range(0, posts.size()).filter(i -> post.getPostId().equals(posts.get(i).getPostId())).findFirst();
        if (optIndex.isPresent()) {
            posts.set(optIndex.getAsInt(), post);
            return true;
        } else {
            return false;
        }
    }
}
