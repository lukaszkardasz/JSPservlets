package pl.n2god.service;

import pl.n2god.model.Post;
import pl.n2god.repository.PostRepository;


import java.util.List;


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


    public List<Post> getPosts() {
        return postRepository.getPosts();
    }
}
