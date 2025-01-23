package com.example.demo.domain.post.tag.entity;

import com.example.demo.domain.post.post.entity.Post;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Tag extends BaseEntity {

    @Column(length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}

