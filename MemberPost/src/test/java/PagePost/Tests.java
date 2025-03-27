package PagePost;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

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
        Memberin member1 = new Memberin();
        member1.setMemberCode(123);
        member1.setMemberId("user01");
        member1.setMemberName("alpaka");

        Memberin member2 = new Memberin();
        member2.setMemberCode(267);
        member2.setMemberId("user02");
        member2.setMemberName("camel");

        EntityTransaction transaction = entityManager.getTransaction(); //
        transaction.begin();

        try {
            entityManager.persist(member1);
            entityManager.persist(member2);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException();
        }
        String jpql = "select m.memberNo from pagePost_Member m";
        List<Integer> members = entityManager.createQuery(jpql, Integer.class).getResultList();

        assertThat(members.size()).isEqualTo(1);
        for (Long memberNo : members) {
            System.out.println(memberNo);
        }


    }

    @DisplayName("게시물")
    @Test
    public void PostAndCommentCreation() {
        Memberin member = new Memberin();
        member.setMemberCode(123);
        member.setMemberId("user01");
        member.setMemberName("alpaka");

        Post post = new Post();
        post.setPostTitle("TEST");
        post.setPostContent("TEST CONTENT");

        Comment comment1 = new Comment();
        comment1.setCommentContent("Comment1");
        comment1.setMemberInformation(member);
        comment1.setPost(Post);


        post.getCommentContent().add(comment1);


        assertThat(foundPost.getPostTitle()).isEqualTo("TEST");
        assertThat(foundPost.getPostContent()).isEqualTo("TEST CONTENT");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(member);
            entityManager.persist(post);
            entityManager.persist(comment1);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException();
        }


    }
}