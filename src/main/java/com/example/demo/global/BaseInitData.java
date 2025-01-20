package com.example.demo.global;

import com.example.demo.domain.post.comment.Service.CommentService;
import com.example.demo.domain.post.comment.entity.Comment;
import com.example.demo.domain.post.post.entity.Post;
import com.example.demo.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;
    private final CommentService commentService;

    @Bean
    @Order(1)
    public ApplicationRunner applicationRunner() {
        return args -> {
           if (postService.count() > 0) {
               return;
           }
           postService.write("title1", "content1");
           postService.write("title1", "content1");
           postService.write("title1", "content1");
        };
    }

//    @Bean
//    @Order(2)
//    public ApplicationRunner applicationRunner2() {
//        return args -> {
//            postService.modify(2L, "new title", "new content");
//        };
//    }
//
//    @Bean
//    @Order(3)
//    public ApplicationRunner applicationRunner3() {
//        return new ApplicationRunner() {
//            @Transactional
//            @Override
//            public void run (ApplicationArguments args) throws Exception {
//                Post p1 = postService.findById(2L).get();
//                postService.delete(p1);
//
//                postService.deleteById(1L);
//            }
//        };
//    }

    @Bean
    @Order(4)
    public ApplicationRunner applicationRunner4() {
        return args -> {
           Post post = postService.findById(1L).get();

            if (commentService.count() > 0) {
                return;
            }

           Comment c1 = commentService.write(post.getId(), "comment1");
           commentService.write(post.getId(), "comment2");
           commentService.write(post.getId(), "comment3");

           postService.findById(c1.getPostId());


        };
    }
}
