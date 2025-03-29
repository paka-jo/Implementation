package PagePost;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="pagePost_Comment")
@Table
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @Column(name="comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(name="comment_code")
    private long commentCode;

    @Column(name="comment_content")
    private String commentContent;

    @ManyToOne
    @JoinColumn(name="post_no")  // Post의 post_no와 매핑
    private Post post;

    @ManyToOne
    @JoinColumn(name="member_information")
    private Member memberInformation;




}
