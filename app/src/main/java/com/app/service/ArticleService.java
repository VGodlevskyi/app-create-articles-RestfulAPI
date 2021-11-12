package com.app.service;

import com.app.dto.ArticleRequest;
import com.app.entity.Article;
import com.app.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticlesRepository articlesRepository;

    public Article createArticle(Article article) {
        return articlesRepository.save(article);
    }

    public Page<Article> getAllArticles(int page, int limit) {
        return articlesRepository.findAll(PageRequest.of(page, limit));
    }

}
