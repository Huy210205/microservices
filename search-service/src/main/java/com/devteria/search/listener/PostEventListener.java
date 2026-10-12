package com.devteria.search.listener;

import com.devteria.search.entity.PostDocument;
import com.devteria.search.event.PostCreatedEvent;
import com.devteria.search.service.PostSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostEventListener {
    PostSearchService service;

    @KafkaListener(topics = "post-created", groupId = "search-service")
    public void onPostCreated(PostCreatedEvent event) {
        log.info("Indexing post {}", event.getId());
        service.index(PostDocument.builder()
                .id(event.getId())
                .userId(event.getUserId())
                .content(event.getContent())
                .createdDate(event.getCreatedDate())
                .modifiedDate(event.getModifiedDate())
                .build());
    }
}
