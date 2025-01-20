package com.example.demo.domain.post.post.service;

import com.example.demo.domain.post.post.entity.Post;
import com.example.demo.domain.post.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(String title, String content) {

        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();

        return postRepository.save(post);
    }

    @Transactional
    public Post modify(Long id, String title, String content) {
        Post post = postRepository.findById(id).get();

        post.setTitle(title);
        post.setContent(content);

        return post;
    }

    public long count() {
        return postRepository.count();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
