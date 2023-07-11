package com.tpa.toyproject_api.Board.Data.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    int views;
    @Column(nullable = false)
    int thumsUp;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getThumsUp() {
        return thumsUp;
    }

    public void setThumsUp(int thumsUp) {
        this.thumsUp = thumsUp;
    }
}
