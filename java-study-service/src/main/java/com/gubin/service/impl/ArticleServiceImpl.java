package com.gubin.service.impl;

import com.gubin.common.entity.Article;
import com.gubin.repository.ArticleRepository;
import com.gubin.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> findDistinctByTitleContainingOrContentContaining(String title, String content, Pageable pageable) {
        return articleRepository.findDistinctByTitleContainingOrContentContaining(title,content,pageable);
    }

    @Override
    public void deleteAll() {
        articleRepository.deleteAll();
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Iterable<Article> findAll() {
        Iterable<Article> list =  articleRepository.findAll();
        return list;
    }

}
