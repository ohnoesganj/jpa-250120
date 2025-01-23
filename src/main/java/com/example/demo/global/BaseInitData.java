package com.example.demo.global;

import com.example.demo.domain.member.Entity.Member;
import com.example.demo.domain.member.Service.MemberService;
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
    @Autowired
    private MemberService memberService;

    @Bean
    @Order(1)
    public ApplicationRunner applicationRunner() {
        return args -> {
           self.work1();
           self.work2();
        };
    }

    @Transactional
    public void work1() {

        if(memberService.count() > 0) {
            return;
        }

        memberService.join("system", "1234", "시스템");
        memberService.join("admin", "1234", "관리자");
        memberService.join("user1", "1234", "유저1");
        memberService.join("user2", "1234", "유저2");
        memberService.join("user3", "1234", "유저3");
    }

    @Transactional
    public void work2() {
        if (postService.count() > 0) {
            return;
        }

        Member user1 = memberService.findByUsername("user1").get();
        Member user2 = memberService.findByUsername("user2").get();
        Member user3 = memberService.findByUsername("user3").get();

        Post p1 = postService.write(user1,"title1", "body1");
        Post p2 = postService.write(user2, "title1", "body2");
        Post p3 = postService.write(user3, "title1", "body3");

        Comment c1 = Comment.builder()
                .author(user1)
                .content("comment1")
                .build();

        p1.addComment(c1);

        Comment c2 = Comment.builder()
                .author(user1)
                .content("comment2")
                .build();

        p1.addComment(c2);

        Comment c3 = Comment.builder()
                .author(user2)
                .content("comment3")
                .build();

        p1.addComment(c3);

    }
}
