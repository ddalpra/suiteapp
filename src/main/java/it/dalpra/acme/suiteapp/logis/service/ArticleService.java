package it.dalpra.acme.suiteapp.logis.service;

import it.dalpra.acme.suiteapp.logis.entity.Article;
import it.dalpra.acme.suiteapp.logis.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        List<Article> articles = articleRepository.findAll();
        articles.forEach(article -> article.getArticleUnits().size()); // Initialize articleUnits
        return articles;
    }

    public Optional<Article> findById(UUID id) {
        return articleRepository.findById(id);
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public void deleteById(UUID id) {
        articleRepository.deleteById(id);
    }
}
