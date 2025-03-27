package PagePost;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="pagePost_Member")
@Table
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 받는 생성자
@Getter
@Setter
@ToString
public class Memberin {

    @Id
    @Column(name="member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GeneratedValue 기본 키값을 자동으로 생성,strategy = GenerationType.IDENTITY identity열을 사용하여 기본키 값을 자동으로 생성하도록 지정
    private long memberNo;

    @Column(name="member_code")
    private long memberCode;

    @Column(name="member_id")
    private String memberId;

    @Column(name="member_name")
    private String memberName;



}
