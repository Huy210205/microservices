package com.devteria.post.service;

import com.devteria.post.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostCreatedEvent {
    String id;
    String userId;
    String content;
    Instant createdDate;
    Instant modifiedDate;

    public static PostCreatedEvent from(Post post) {
        return PostCreatedEvent.builder()
                .id(post.getId())
                .userId(post.getUserId())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .modifiedDate(post.getModifiedDate())
                .build();
    }
}
