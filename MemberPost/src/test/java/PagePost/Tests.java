package PagePost;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("noticeBoard");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @DisplayName("회원 정보")
    @Test
    public void MemberRepositoryTest() {
        Member member1 = new Member();
        member1.setMemberCode(123);
        member1.setMemberId("user01");
        member1.setMemberName("alpaka");

        Member member2 = new Member();
        member2.setMemberCode(267);
        member2.setMemberId("user02");
        member2.setMemberName("camel");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        try {
            entityManager.persist(member1);
            entityManager.persist(member2);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }

        String jpql = "SELECT m from pagePost_Member m";
        List<Member> members = entityManager.createQuery(jpql, Member.class).getResultList();

        assertEquals(2, members.size(), "Should have 2 members in the database");

    }

    @DisplayName("게시물")
    @Test
    public void PostAndCommentTest() {

        Member member1 = new Member();
        member1.setMemberCode(123);
        member1.setMemberId("user01");
        member1.setMemberName("alpaka");


        Post post = new Post();
        post.setPostCode(1);
        post.setPostTitle("TestPost");
        post.setPostContent("TestPostContent");

        if (post.getComments() == null) {
            post.setComments(new ArrayList<>());
        }

        Comment comment = new Comment();
        comment.setCommentCode(1);
        comment.setCommentContent("HaHa");
        comment.setMemberInformation(member1);

        post.getComments().add(comment);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(member1);
            entityManager.persist(post);
            entityManager.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }


        assertEquals("TestPost", post.getPostTitle(), "포스트 제목이 일치해야 합니다");
        assertEquals("TestPostContent", post.getPostContent(), "포스트 내용이 일치해야합니다");
        assertEquals("HaHa", comment.getCommentContent(), "댓글 내용이 일치해야합니다");




    }



    }