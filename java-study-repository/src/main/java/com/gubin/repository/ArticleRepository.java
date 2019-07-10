package com.gubin.repository;

import com.gubin.common.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

    Page<Article> findDistinctByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

}
