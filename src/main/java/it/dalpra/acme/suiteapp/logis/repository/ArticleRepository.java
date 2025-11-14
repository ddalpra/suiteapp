package it.dalpra.acme.suiteapp.logis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dalpra.acme.suiteapp.logis.entity.Article;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, UUID>{
    Optional<Article> findByCodeArticle(String codeArticle);
}
