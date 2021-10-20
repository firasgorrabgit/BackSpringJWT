package com.teck.spring.security.postgresql.repository;

import com.teck.spring.security.postgresql.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
