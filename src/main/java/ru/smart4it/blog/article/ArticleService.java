package ru.smart4it.blog.article;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.smart4it.blog.article.dto.ArticleDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Page<ArticleDto> getArticles(Pageable pageable) {
        log.info("getArticles started: pageable={}", pageable);
        Page<Article> articlePage = articleRepository.findAll(pageable);
        List<ArticleDto> articleDtoList = articlePage.getContent().stream().map(ArticleDto::new).toList();
        log.info("getArticles completed: pageable={}, total={}", pageable, articlePage.getTotalElements());
        return new PageImpl<>(articleDtoList, articlePage.getPageable(), articlePage.getTotalElements());
    }
}
