package pl.n2god.model;

import pl.n2god.model.enimeration.Role;


import java.time.LocalDateTime;
import java.util.Objects;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) &&
                Objects.equals(user, post.user) &&
                Objects.equals(date, post.date) &&
                Objects.equals(postData, post.postData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, user, date, postData);
    }
}
