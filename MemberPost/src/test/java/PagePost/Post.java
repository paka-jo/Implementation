package PagePost;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="pagePost_Post")
@Table
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자
@Getter
@Setter
@ToString
public class Post {

    @Id
    @Column(name="post_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postno;

    @Column(name="post_code")
    private long postCode;

    @Column(name="post_title")
    private String postTitle;

    @Column(name="post_content")
    private String postContent;

    @OneToMany(mappedBy="post",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;




}
