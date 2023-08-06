package ru.smart4it.blog.article;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.smart4it.blog.article.dto.ArticleDto;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Page<ArticleDto> getArticles(Pageable pageable) {
        log.info("getArticles started: pageable={}", pageable);
        Page<Article> articlePage = articleRepository.findAll(pageable);
        List<ArticleDto> articleDtoList = articlePage.getContent()
                .stream()
                .map(article -> new ArticleDto(article, createPreview(article)))
                .toList();
        log.info("getArticles completed: pageable={}, total={}", pageable, articlePage.getTotalElements());
        return new PageImpl<>(articleDtoList, articlePage.getPageable(), articlePage.getTotalElements());
    }

    private String createPreview(Article article) {
        int lastIndex = Math.min(article.getContent().length(), 250);
        return article.getContent().substring(0, lastIndex) + "...";
    }

    public ArticleDto getById(UUID id) {
        log.info("getById started: id={}", id);
        ArticleDto dto = articleRepository.findById(id)
                .map(article -> new ArticleDto(article, createPreview(article)))
                .orElseThrow(() -> new NotFoundException("article not found"));
        log.info("getById completed: id={}", id);
        return dto;
    }
}
