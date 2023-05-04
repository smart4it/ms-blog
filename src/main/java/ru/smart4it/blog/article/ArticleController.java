package ru.smart4it.blog.article;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smart4it.blog.article.dto.ArticleDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
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
}