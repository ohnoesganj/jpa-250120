package com.example.demo.domain.post.post.entity;

import com.example.demo.domain.member.Entity.Member;
import com.example.demo.domain.post.comment.entity.Comment;
import com.example.demo.domain.post.tag.entity.Tag;
import com.example.demo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Post extends BaseTimeEntity {

    private String title;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @Builder.Default
    private List<Tag> tags = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void addTag(String name) {
        Tag tag = Tag.builder()
                .name(name)
                .post(this)
                .build();

        tags.add(tag);
    }
}
