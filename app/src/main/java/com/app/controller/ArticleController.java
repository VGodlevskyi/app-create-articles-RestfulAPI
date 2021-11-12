package com.app.controller;

import com.app.dto.ArticleRequest;
import com.app.dto.ArticleResponse;
import com.app.entity.Article;
import com.app.facade.ArticleFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("articles")
public class ArticleController {

    private final ArticleFacade articleFacade;

    @PostMapping("create")
    public Article createArticle(@RequestBody ArticleRequest articleRequest) {
        return articleFacade.createArtical(articleRequest);
    }

    @GetMapping("")
    public List<ArticleResponse> getAllArticles(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        return articleFacade.getAllArticles(page, limit);
    }
}
