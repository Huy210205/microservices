# Search Service

Search Service indexes posts in Elasticsearch and exposes full-text search through
`GET /search/posts?keyword=...`. New posts are synchronized asynchronously from
the Kafka topic `post-created`.
