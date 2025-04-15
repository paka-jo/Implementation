package com.example.demo.dto;

import java.time.LocalDateTime;

public class PostDTO {

    private Long postId;
    private Long userId;
    private String postTitle;
    private String postContent; //내용
    private String userNickname;
    private LocalDateTime postCreatedAt;

    public PostDTO() {}

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long pageId) {
        this.postId = pageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickName) {
        this.userNickname = userNickName;
    }

    public LocalDateTime getPostCreatedAt() {
        return postCreatedAt;
    }

    public void setPostCreatedAt(LocalDateTime postCreatedAt) {
        this.postCreatedAt = postCreatedAt;
    }
}

