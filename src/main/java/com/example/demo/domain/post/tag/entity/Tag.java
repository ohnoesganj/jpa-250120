package com.example.demo.domain.post.tag.entity;

import com.example.demo.domain.post.post.entity.Post;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tag {

    @EmbeddedId
    private TagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Include
    @MapsId("postId")
    private Post post;
}

