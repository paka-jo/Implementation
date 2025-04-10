package com.example.demo.dto;

import java.time.LocalDateTime;

public class PostDTO {

    private Long id;
    private String title;
    private String content; //내용
    private String nickname;
    private LocalDateTime createdAt;

    public PostDTO() {}

    public PostDTO(Long id, String title, String content, String nickname, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.createdAt = createdAt;
    }

    public PostDTO(long postCode, String postTitle, String pageNickname, LocalDateTime postCreatedAt) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}