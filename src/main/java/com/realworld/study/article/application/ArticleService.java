package com.realworld.study.article.application;

import com.realworld.study.article.application.dto.ArticleRequest;
import com.realworld.study.article.application.dto.ArticleUpdateRequest;
import com.realworld.study.article.domain.Article;
import com.realworld.study.article.domain.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article save(final ArticleRequest articleRequest) {
        return articleRepository.save(articleRequest.toEntity());
    }

    public void update(final Long id, final ArticleUpdateRequest articleUpdateRequest) {
        Article article = articleRepository.findById(id).orElseThrow();

        article.update(articleUpdateRequest.getTitle(),
                articleUpdateRequest.getDescription(),
                articleUpdateRequest.getBody());

        articleRepository.save(article);
    }

    public void delete(final Long id) {
        articleRepository.deleteById(id);
    }
}
