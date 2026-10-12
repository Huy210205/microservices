package com.devteria.search.service;

import com.devteria.search.entity.PostDocument;
import com.devteria.search.repository.PostSearchRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostSearchService {
    PostSearchRepository repository;
    ElasticsearchOperations operations;

    public void index(PostDocument post) {
        repository.save(post);
    }

    public List<PostDocument> search(String keyword, int page, int size) {
        var query = NativeQuery.builder()
                .withQuery(q -> q.multiMatch(m -> m.query(keyword).fields("content", "userId")))
                .withPageable(PageRequest.of(page, size))
                .build();
        SearchHits<PostDocument> hits = operations.search(query, PostDocument.class);
        return hits.getSearchHits().stream().map(hit -> hit.getContent()).toList();
    }
}
