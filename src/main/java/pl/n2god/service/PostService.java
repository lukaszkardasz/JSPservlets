package pl.n2god.service;

import pl.n2god.model.Post;
import pl.n2god.model.User;
import pl.n2god.model.enimeration.Role;
import pl.n2god.repository.PostRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class PostService {

    private PostRepository postRepository;
    private static PostService instance = null;

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }

    private PostService() {
        this.postRepository = PostRepository.getInstance();
    }

    public void addPost(String postData, User user) {
        Post post = new Post(postData, user);
        postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public void delete(long id){
        postRepository.delete(id);
    }


    public Optional<Post> getPost(Long id) {
        return postRepository.getPost(id);
    }
}
