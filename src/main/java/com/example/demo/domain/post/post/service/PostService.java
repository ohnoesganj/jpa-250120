package com.example.demo.domain.post.post.service;

import com.example.demo.domain.member.Entity.Member;
import com.example.demo.domain.post.post.entity.Post;
import com.example.demo.domain.post.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(Member author, String title, String body) {

        Post post = Post.builder()
                .author(author)
                .title(title)
                .body(body)
                .build();

        return postRepository.save(post);
    }

    @Transactional
    public Post modify(Long id, String title, String body) {
        Post post = postRepository.findById(id).get();

        post.setTitle(title);
        post.setBody(body);

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

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public List<Post> findByTitleAndBody(String title1, String body1) {
        return postRepository.findByTitleAndBody(title1, body1);
    }

    public List<Post> findByTitleLike(String s) {
        return postRepository.findByTitleLike(s);
    }

    public Page findByTitleLike(String s, Pageable pageable) {
        return postRepository.findByTitleLike(s, pageable);
    }

    public List<Post> findByOrderByIdDesc() {
        return postRepository.findByOrderByIdDesc();
    }

    public List<Post> findTop2ByTitleOrderByDesc(String title1) {
        return postRepository.findTop2ByOrderByIdDesc();
    }

    public List<Post> findByAuthorUsername(String username) {
        return postRepository.findByAuthorUsername(username);
    }
}
