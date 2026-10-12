package com.devteria.search.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class PostCreatedEvent {
    private String id;
    private String userId;
    private String content;
    private Instant createdDate;
    private Instant modifiedDate;
}
