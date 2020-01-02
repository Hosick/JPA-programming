package me.hosick.demospringdata;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    /* @PersistenceContext
     EntityManager entityManager;*/
    @Autowired
    PostRepository postRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        postRepository.findAll().forEach(System.out::println);
    }

        /*TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);*/

        /*      Account account = new Account();
        account.setUsername("hoseok");
        account.setPassword("jpa123");

        Study study = new Study();
        study.setName("Spring Data JPA");*/

        /*account.addStudy(study);    //  두개를 묶은 convenient한 메소드
        study.setOwner(account);
        account.getStudies().add(study);*/
/*
        Post post = new Post();
        post.setTitle("Spring Data JPA 언제보냐....");

        Comment comment = new Comment();
        comment.setComment("빨리 보고 싶어요.");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("곧 보여드릴께요. ");
        post.addComment(comment1);


        Session session = entityManager.unwrap(Session.class);
        session.save(post);*/
        /*session.save(account);
        session.save(study);

        Account hosick = session.load(Account.class, account.getId());*/
}
