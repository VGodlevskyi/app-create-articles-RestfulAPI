package com.app.controller;

import com.app.dto.ArticleRequest;
import com.app.dto.ArticleResponse;
import com.app.entity.Article;
import com.app.facade.ArticleFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("articles")
public class ArticleController {

    private final ArticleFacade articleFacade;

    @PostMapping("create")
    public Article createArticle(@RequestBody ArticleRequest articleRequest) {
        log.info("Article create");
        return articleFacade.createArtical(articleRequest);
    }

    @GetMapping("")
    public List<ArticleResponse> getAllArticles(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        log.info("getListArticles");
        return articleFacade.getAllArticles(page, limit);
    }

    @GetMapping("statistic")
    public Integer getStatistic() {
        log.info("getStatistic");
        return articleFacade.getArticlesForLastWeek().size();
    }
}
