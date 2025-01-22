package com.example.demo.domain.post.post.repository;

import com.example.demo.domain.post.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitle(String title);

    List<Post> findByTitleAndBody(String title, String body);

    List<Post> findByTitleLike(String title);

    Page<Post> findByTitleLike(String title, Pageable pageable);

    List<Post> findByOrderByIdDesc();

    List<Post> findTop2ByOrderByIdDesc();

    Page<Post> findAll(Pageable pageable);
}
