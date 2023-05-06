package ru.smart4it.blog.article;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import ru.smart4it.blog.article.dto.ArticleDto;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @CrossOrigin
    @GetMapping
    public Page<ArticleDto> getArticles(@PageableDefault Pageable pageable) {
        log.info("getArticles started: pageable={}", pageable);
        Page<ArticleDto> response = articleService.getArticles(pageable);
        log.info("getArticles completed: pageable={}", pageable);
        return response;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ArticleDto article(@PathVariable UUID id) {
        log.info("article started: id={}", id);
        ArticleDto dto = articleService.getById(id);
        log.info("article completed: id={}", id);
        return dto;
    }
}