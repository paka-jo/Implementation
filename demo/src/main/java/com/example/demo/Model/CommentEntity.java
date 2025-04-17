package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="comments")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CommentEntity {

    @Id
    @Column(name="comment_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;


    @Column(name="User_id") // 회원 아이디
    private String userId;

    @Column(name="comment_content")
    private String commentContent;

    @Column(name="user_nickname")
    private String userNickname;

    @Column(name="comment_createdAt")
    private LocalDateTime commentCreatedAt;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;
}
