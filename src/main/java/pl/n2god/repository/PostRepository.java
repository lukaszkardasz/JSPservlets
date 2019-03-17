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
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void save(Post post) {
        post.setId(IdGenerator.next());
        post.setCreatedDate(LocalDateTime.now());
        posts.add(post);
    }

    public Optional<Post> getPost(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public boolean update(Post post) {
        OptionalInt optIndex = IntStream.range(0, posts.size()).filter(i -> post.getId().equals(posts.get(i).getId())).findFirst();
        if (optIndex.isPresent()) {
            posts.set(optIndex.getAsInt(), post);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Post> deletePost(Long id) {
        Optional<Post> optRemovedPost = getPost(id);
        optRemovedPost.ifPresent(removedPost -> posts.removeIf(post -> post.equals(removedPost)));
        return optRemovedPost;
    }
}
