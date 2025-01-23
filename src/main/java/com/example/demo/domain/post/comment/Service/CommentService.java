package com.example.demo.domain.post.comment.Service;

import com.example.demo.domain.member.Entity.Member;
import com.example.demo.domain.post.comment.entity.Comment;
import com.example.demo.domain.post.comment.repository.CommentRepository;
import com.example.demo.domain.post.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment write(Member author, Post post, String content) {
        Comment comment = Comment.builder()
                        .author(author)
                        .post(post)
                        .content(content)
                        .build();

        return commentRepository.save(comment);
    }

    public long count() {
        return commentRepository.count();
    }

    public Optional<Comment> findById(long id) {
        return commentRepository.findById(id);
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }
}
