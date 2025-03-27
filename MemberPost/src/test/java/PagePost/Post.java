package PagePost;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    @Column(name="post_code")
    private long code;

    @Column(name="post_title")
    private String title;

    @Column(name="post_content")
    private String content;

    @OneToMany(mappedBy="comment_content")
    private List<Comment> commentContent;


}
