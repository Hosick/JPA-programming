package me.hosick.demojpa.post;

import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);  //  insert query 발생

        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(post == savedPost);

        Post postUpdate = new Post();
        post.setTitle("hibernate");
        Post updatedPost = postRepository.save(postUpdate);    //  update query 발생

        assertThat(entityManager.contains(postUpdate)).isTrue();
        assertThat(entityManager.contains(updatedPost)).isTrue();
        assertThat(postUpdate == updatedPost);

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    public void findByTitleStartsWith() {
        Post post = new Post();
        post.setTitle("spring data jpa");
        postRepository.save(post);

        List<Post> all = postRepository.findByTitleStartsWith("spring");
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void findByTitle() {
        Post post = new Post();
        post.setTitle("spring");
        postRepository.save(post);

        List<Post> all = postRepository.findByTitle("spring", Sort.by("title"));
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void crud() {

        /*Post post = new Post();
        post.setTitle("hibernet");
        postRepository.save(post.publish());

        Predicate predicate = QPost.post.title.containsIgnoreCase("Hi");
        Optional<Post> one =  postRepository.findOne(predicate);
        assertThat(one).isNotEmpty();*/

        /*assertThat(postRepository.contains(post)).isFalse();

        postRepository.save(post.publish());

        assertThat(postRepository.contains(post)).isTrue();

        postRepository.delete(post);
        postRepository.flush();*/
    }



}