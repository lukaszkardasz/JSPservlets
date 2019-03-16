package pl.n2god.model;

import pl.n2god.model.enimeration.Role;


import java.time.LocalDateTime;

public class Post {

    private Long postId;
    private User user;
    private LocalDateTime date;
    private String postData;

    public Post(String postData, User user) {
        this.user = user;
        this.postData = postData;
    }

    public Post (){

    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
