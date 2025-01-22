package com.example.demo.global;

import com.example.demo.domain.post.comment.Service.CommentService;
import com.example.demo.domain.post.comment.entity.Comment;
import com.example.demo.domain.post.post.entity.Post;
import com.example.demo.domain.post.post.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;
    private final CommentService commentService;

    @Lazy
    @Autowired
    private BaseInitData self;

    @Bean
    @Order(1)
    public ApplicationRunner applicationRunner() {
        return args -> {
           self.work1();
           self.work2();
        };
    }

    @Transactional
    public void work2() {
//        Post post = postService.findById(1L).get();
//
//        postService.delete(post);
    }

    @Transactional
    public void work1() {
        if (postService.count() > 0) {
            return;
        }

        Post p1 = postService.write("title1", "body1");
        Post p2 = postService.write("title1", "body2");
        Post p3 = postService.write("title1", "body3");

        Comment c1 = Comment.builder()
                .content("comment1")
                .build();

        p1.addComment(c1);

        Comment c2 = Comment.builder()
                .content("comment2")
                .build();

        p1.addComment(c2);

        Comment c3 = Comment.builder()
                .content("comment3")
                .build();

        p1.addComment(c3);

    }
}
