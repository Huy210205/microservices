package com.devteria.search.repository;

import com.devteria.search.entity.PostDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostSearchRepository extends ElasticsearchRepository<PostDocument, String> {
}
