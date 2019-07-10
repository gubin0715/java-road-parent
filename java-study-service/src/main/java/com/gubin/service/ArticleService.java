package com.gubin.service;

import com.gubin.common.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    Page<Article> findDistinctByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

    void deleteAll();

    void save(Article article);

    Iterable<Article> findAll();
}
