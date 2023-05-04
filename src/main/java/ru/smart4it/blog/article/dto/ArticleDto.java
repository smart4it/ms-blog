package ru.smart4it.blog.article.dto;

import ru.smart4it.blog.article.Article;

import java.time.LocalDateTime;
import java.util.UUID;

public record ArticleDto(UUID id, String title, String content, LocalDateTime created, LocalDateTime updated) {
    public ArticleDto(Article article) {
        this(article.getId(), article.getTitle(), article.getContent(), article.getCreated(), article.getUpdated());
    }
}
