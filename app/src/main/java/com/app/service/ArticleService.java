package com.app.service;

import com.app.entity.Article;
import com.app.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Value("604800000")
    private Long sevenDays;

    public boolean ifArticleCreatedLastWeek(Article article) throws ParseException {
        long now = new Date().getTime();
        long weekAgo = now - sevenDays;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        long dateArticle = format.parse(article.getDatePublishing()).getTime();
        System.out.printf("now %d , weekAgo %d, dateArticle %d", now,weekAgo, dateArticle);
        return dateArticle >= weekAgo && dateArticle <= now;
    }

    public List<Article> getArticlesForLastWeek() {
        List<Article> listSevenDays = new ArrayList<>();
        articlesRepository.findAll().forEach(a -> {
            try {
                if (ifArticleCreatedLastWeek(a)) listSevenDays.add(a);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        return listSevenDays;
    }

}
