package pl.n2god.service;

import pl.n2god.model.Post;
import pl.n2god.model.User;
import pl.n2god.repository.PostRepository;


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
        Post postToAdd = new Post(postData, user);
        postRepository.save(postToAdd);
    }

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public Optional<Post> deletePost(long id){
        Optional<Post> optRemovedPost = postRepository.getPost(id);
        if (optRemovedPost.isPresent()) {
            return postRepository.deletePost(id);
        } else {
            return optRemovedPost;
        }
    }


    public Optional<Post> getPost(Long id) {
        return postRepository.getPost(id);
    }
}
