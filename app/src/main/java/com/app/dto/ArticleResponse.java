package com.app.dto;

import lombok.Data;

@Data
public class ArticleResponse {

    private Long id;
    private String title;
    private String author;
    private String content;
    private String datePublishing;

}
