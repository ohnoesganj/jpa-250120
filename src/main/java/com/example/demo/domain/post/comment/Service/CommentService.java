package com.example.demo.domain.post.comment.Service;

import com.example.demo.domain.post.comment.entity.Comment;
import com.example.demo.domain.post.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment write(long postId, String content) {
        Comment comment = Comment.builder()
                        .postId(postId)
                        .content(content)
                        .build();

        return commentRepository.save(comment);
    }

    public long count() {
        return commentRepository.count();
    }
}
