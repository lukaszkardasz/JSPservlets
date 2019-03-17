package pl.n2god.model;


import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private Long id;
    private String text;
    private User user;
    private LocalDateTime createdDate;

    public Post(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(text, post.text) &&
                Objects.equals(user, post.user) &&
                Objects.equals(createdDate, post.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, user, createdDate);
    }
}

