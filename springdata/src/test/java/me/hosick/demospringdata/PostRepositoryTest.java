package me.hosick.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository(){
        //Given
        Post post = new Post();
        post.setTitle("hello spring boot common");
        assertNull(post.getId());

        //When
        Post newPost = postRepository.save(post);

        //Then
        assertNotNull(newPost.getId());
    }

}