package com.example.demo.Model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name="posts")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostEntity {

    @Id
    @Column(name="post_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postCode;

    @Column(name="page_id")
    private String pageId;

    @Column(name="post_title")
    private String postTitle;

    @Column(name="post_content")
    private String postContent;

    @Column(name="page_nickname")
    private String pageNickname;

    // postcreatat 필드를 JOSN으로 직렬화 할 때 사용
    @Column(name="post_createdAt")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime postCreatedAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

}
