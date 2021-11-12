package com.app.facade;

import com.app.dto.ArticleRequest;
import com.app.dto.ArticleResponse;
import com.app.entity.Article;
import com.app.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleFacade implements Facade<Article, ArticleResponse, ArticleRequest> {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    ArticleService articleService;

    @Override
    public ArticleResponse toDTOResponse(ArticleRequest articleRequest) {
        return mapper.map(articleRequest, ArticleResponse.class);
    }

    @Override
    public ArticleRequest toDTORequest(ArticleResponse articleResponse) {
        return mapper.map(articleResponse, ArticleRequest.class);
    }

    @Override
    public ArticleResponse fromEntity(Article entity) {
        return mapper.map(entity, ArticleResponse.class );
    }

    @Override
    public Article toEntity(ArticleRequest articleRequest) {
        return mapper.map(articleRequest, Article.class);
    }

    public Article createArtical(ArticleRequest articleRequest) {
        Article article = this.toEntity(articleRequest);
        return articleService.createArticle(article);
    }

    public List<ArticleResponse> getAllArticles(int page, int limit) {
        return articleService
                .getAllArticles(page, limit)
                .stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

}
