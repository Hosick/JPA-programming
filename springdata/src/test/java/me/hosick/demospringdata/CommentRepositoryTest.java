package me.hosick.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud(){

        this.createComment(100,"spring data jpa");
        this.createComment(55, "HIBERNATE SPRING");

        PageRequest pageRequest = new PageRequest(0,10, Sort.by(Sort.Direction.DESC,"LikeCount"));

        Page<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
        assertThat(comments.getNumberOfElements()).isEqualTo(2);
        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount",100);


        /*Comment comment = new Comment();
        comment.setComment("Hello Comment");
        commentRepository.save(comment);

        List<Comment> all =  commentRepository.findAll();
        assertThat(all.size()).isEqualTo(1);

        long count = commentRepository.count();
        assertThat(count).isEqualTo(1);*/

        /*List<Comment> comments = commentRepository.findAll();
        assertThat(comments).isEmpty();*/
    }

    private void createComment(int likeCount, String comment){
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(likeCount);
        commentRepository.save(newComment);
    }
}